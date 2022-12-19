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

    //constructor
    Game(Set<Player> players, List<Cell> cells, boolean isEnded, String winner) {
        this.players = players;
        this.cells = cells;
        this.isEnded = isEnded;
        this.winner = winner;
        this.firstDice = 0;
        this.secondDice = 0;
    }

    //starts the game
    public void startGame(Game game, Player player){
        newTurn(game, player, firstDice, secondDice);
    }

    //initializes the cells on the game board
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

    //creates a new players after checking if the player doesn't already exist
    public String createPlayer(String username, Game game) {
        if (playerCheck(username))
            return username + ": already existing player.";
        else {
            Player player = new Player(username, game.getId(), getCells().get(0));
            players.add(player);
            getCells().get(0).setPlayer(player);
        }

        listPlayers(getPlayers());
        return "Player added successfully";
    }

    //checks if a player already exist
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
    public void newTurn(Game game, Player currentPlayer, int firstDice, int secondDice) {
        currentPlayer.rollDices(game, currentPlayer, firstDice, secondDice);
    }

    //moves the player to a new cell
    public void movePlayer(Game game, Player player, Cell currentCell){
        int newPosition = currentCell.getId() + firstDice + secondDice;

        if(newPosition>63)
            newPosition = bounce(newPosition);

        System.out.print(player.getUsername() + " rolls " + firstDice + ", " + secondDice + ". ");

        int destinationCellPosition = cells.get(newPosition).land(game, player, firstDice, secondDice);
        player.setCell(cells.get(destinationCellPosition));

        if(destinationCellPosition==63){
            System.out.println(player.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice()
                    + ". " + player.getUsername() + " moves from " + currentCell.getId() + " to "
                    + destinationCellPosition + ". " + player.getUsername() + " Wins!!");
            game.setWinner(player.getUsername());
            game.setEnded(true);
        }
    }

    //bounces the player if he doesn't roll the exact number of cells needed to reach the winning one
    public int bounce(int newPosition){
        newPosition = 63 - (newPosition - 63);
        return newPosition;
    }
}
