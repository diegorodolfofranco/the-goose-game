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
    private String id;
    private Set<Player> players;
    private List<Cell> cells;
    private boolean isEnded;
    private String winner;
    private int firstDice;
    private int secondDice;

    /*public Game(){
        this("", new LinkedHashSet<>(), new ArrayList<>(), false, "");
    }*/

    public Game(Set<Player> players, List<Cell> cells, boolean isEnded, String winner) {
        this.players = players;
        this.cells = cells;
        this.isEnded = isEnded;
        this.winner = winner;
    }

    /*public Game(String id, Set<Player> players, List<Cell> cells, boolean isEnded, String winner) {
        this.id = id;
        this.players = players;
        this.cells = cells;
        this.isEnded = isEnded;
        this.winner = winner;
    }*/

    public void startGame(String id, Player firstPlayer, List<Cell> cells){
        newTurn(this, firstPlayer);
        firstDice = (int) (Math.random() * 6) + 1;
        secondDice = (int) (Math.random() * 6) + 1;
    }

    //starts a new turn
    public void newTurn(Game game, Player player) {
        while(!isEnded) {
                if(player.getPosition()!=63)
                    player.rollDices(game);
                else {
                    isEnded = true;
                    winner = player.getUsername();
                    return;
                }
        }
    }

    //creates a new players after checking that the player doesn't already exist
    public String createPlayer(String username) {

        if (playerCheck(username))
            return username + ": already existing player.";
        else
            players.add(new Player(id, username));

        listPlayers(getPlayers());
        return "Player added successfully";
    }

    //lists all the players in the game
    public String listPlayers(Set<Player> players) {
        StringBuilder message = new StringBuilder("Players: ");

        for (Player player : players) {
            message.append(" ").append(player.getUsername());
        }

        return message.toString();
    }

    //checks if a player doesn't already exist
    public boolean playerCheck(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username))
                return true;
        }

        return false;
    }

    //initializes the cells on the board
    public List<Cell> initializeBoard() {
        cells.add(new StartCell(0));

        int i=1;
        do {
            if (i != 5 && i != 6 && i != 9 && i != 13 && i != 18 && i != 23 && i != 27) {
                cells.add(new StandardCell(i));
                System.out.println(i);
            }

            i++;
        } while (i < 64);

        cells.add(new GooseCell(5));
        cells.add(new BridgeCell(6));
        cells.add(new GooseCell(9));
        cells.add(new GooseCell(13));
        cells.add(new GooseCell(18));
        cells.add(new GooseCell(23));
        cells.add(new GooseCell(27));

        return cells;
    }

    //adds a players to the list of players in the game
    public void addPlayer(Player player) {
        players.add(player);
    }

    //returns the players that occupy a certain cell on the board
    public Player getCellOccupant(int position) {
        Player occupant = new Player();

        for (Player player : players) {
            if (player.getPosition() == position) {
                occupant = player;
            }
        }

        return occupant;
    }

    public Set<Player> getCellOccupants(int position) {
        Set<Player> occupants = new LinkedHashSet<>();

        for (Player player : players) {
            if (player.getPosition() == position) {
                occupants.add(player);
            }
        }

        return occupants;
    }
}
