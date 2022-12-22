package org.thegoosegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.cell.*;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.cell.CellService;

import java.util.Set;

@Service
public class GameService {
    @Autowired
    private Game game;
    @Autowired
    CellService cellService;

    @Autowired
    GameService(Game game, CellService cellService){
        this.game = game;
        this.cellService = cellService;
    }

    //initializes the cells on the game board
    public void initializeBoard() {
        game.getCells().add(new StartCell(0));

        int i=1;
        do {
            game.getCells().add(new StandardCell(i));
            i++;
        } while (i < 64);

        game.getCells().set(5, new GooseCell(5));
        game.getCells().set(6, new BridgeCell(6));
        game.getCells().set(9, new GooseCell(9));
        game.getCells().set(13, new GooseCell(13));
        game.getCells().set(18, new GooseCell(18));
        game.getCells().set(27, new GooseCell(27));
    }

    //creates a new players after checking if the player doesn't already exist
    public String createPlayer(String username) {
        if (playerCheck(username))
            return username + ": already existing player.";
        else {
            Player player = new Player(username, game.getCells().get(0).getId());
            game.getPlayers().add(player);
            game.getCells().get(0).setPlayer(player);
        }

        return game.getPlayers().toString();
    }

    //checks if a player already exist
    public boolean playerCheck(String username) {
        for (Player player : game.getPlayers()) {
            if (player.getUsername().equals(username))
                return true;
        }

        return false;
    }

    //lists all the players in the game
    public String listPlayers(Set<Player> players) {
        StringBuilder message = new StringBuilder("Players: ");

        for (Player player : players) {
            message.append(" ").append(player.getUsername());
        }

        return message.toString();
    }

    public String newTurn(Player player){
        game.setFirstDice((int) (Math.random() * 6) + 1);
        game.setSecondDice((int) (Math.random() * 6) + 1);
        return movePlayer(game, player, player.getCell());
    }

    //starts a new turn
    public String newTurn(Player player, int firstDice, int secondDice) {
        game.setFirstDice(firstDice);
        game.setSecondDice(secondDice);
        return movePlayer(game, player,player.getCell());
    }

    //moves the player to a new cell
    public String movePlayer(Game game, Player player, int currentCellId){
        Cell currentCell = game.getCells().get(currentCellId);
        int newPosition = currentCell.getId() + game.getFirstDice() + game.getSecondDice();
        String moveResponse;

        if(newPosition>63)
            newPosition = bounce(newPosition);

        moveResponse = player.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice() + ". ";

        Cell landingCell = game.getCells().get(newPosition);
        int destinationCellPosition = cellService.landOnCell(game, landingCell);
        player.setCell(game.getCells().get(destinationCellPosition).getId());

        if(destinationCellPosition==63){
            moveResponse = moveResponse.concat(player.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice()
                    + ". " + player.getUsername() + " moves from " + currentCell.getId() + " to "
                    + destinationCellPosition + ". " + player.getUsername() + " Wins!!");
            game.setWinner(player.getUsername());
            game.setEnded(true);
        }

        return moveResponse;
    }

    //bounces the player if he doesn't roll the exact number of cells needed to reach the winning one
    public int bounce(int newPosition){
        newPosition = 63 - (newPosition - 63);
        return newPosition;
    }

    public Set<Player> findAll() {
        return game.getPlayers();
    }

    public Player findPlayerByUsername(String username) throws PlayerNotFoundException {
        return game.getPlayers().stream().filter(stream -> stream.getUsername().equals(username)).findFirst().orElseThrow(PlayerNotFoundException::new);
    }
}
