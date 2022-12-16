package org.thegoosegame.game;

import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Game {
    private final String id = UUID.randomUUID().toString();
    private Set<Player> players = new LinkedHashSet<>();
    private List<Cell> cells = new ArrayList<>();
    private boolean isEnded;
    private String winner;
    private int firstDice;
    private int secondDice;

    Game(Set<Player> players, List<Cell> cells, boolean isEnded, String winner) {
        this.players = players;
        this.cells = cells;
        this.isEnded = isEnded;
        this.winner = winner;
        this.firstDice = 0;
        this.secondDice = 0;
    }

    //starts the game
    public void startGame(Player player, boolean dicesRolled){
        while(!isEnded) {
            if(dicesRolled)
                newTurn(player, firstDice, secondDice);
            else
                newTurn(player);
        }
    }

    //initializes the cells on the board
    public void initializeBoard() {
        cells.add(new StartCell(getId(), 0));

        int i=1;
        do {
                cells.add(new StandardCell(getId(), i));
            i++;
        } while (i < 64);

        cells.set(5, new GooseCell(getId(),5));
        cells.set(6, new BridgeCell(getId(),6));
        cells.set(9, new GooseCell(getId(),9));
        cells.set(13, new GooseCell(getId(), 13));
        cells.set(18, new GooseCell(getId(), 18));
        cells.set(23, new GooseCell(getId(), 23));
        cells.set(27, new GooseCell(getId(), 27));
    }

    //creates a new players after checking that the player doesn't already exist
    public String createPlayer(String username) {
        if (playerCheck(username))
            return username + ": already existing player.";
        else
            players.add(new Player(username, getCells().get(0)));

        listPlayers(getPlayers());
        return "Player added successfully";
    }

    //checks if a player doesn't already exist
    public boolean playerCheck(String username) {
        for (Player player : players) {
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

    //starts a new turn
    public void newTurn(Player currentPlayer) {
        currentPlayer.rollDices(currentPlayer,firstDice,secondDice);
    }

    public void newTurn(Player currentPlayer, int firstDice, int secondDice) {

        currentPlayer.rollDices(currentPlayer,firstDice,secondDice);
    }

    public void movePlayer(Player player, Cell currentCell){
        int newPosition = currentCell.getId() + firstDice + secondDice;

        if(newPosition>63)
            newPosition = bounce(newPosition);

        int destinationCellPosition = cells.get(newPosition).land(player);
        player.setCell(cells.get(destinationCellPosition));

        Game game = new Game();

        if(destinationCellPosition==63){
            System.out.println(player.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice()
                    + ". " + player.getUsername() + " moves from " + currentCell.getId() + " to "
                    + destinationCellPosition + ". " + player.getUsername() + " Wins!!");
            game.setWinner(player.getUsername());
            game.setEnded(true);
        }
    }

    public int bounce(int newPosition){
        newPosition = 63 - (newPosition - 63);
        return newPosition;
    }
}
