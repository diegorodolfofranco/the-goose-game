package org.thegoosegame.game;

import java.util.*;

public class Game {
    String id;
    private Set<Player> players = new HashSet<Player>();
    private List<Cell> cells = new ArrayList<Cell>(64);
    private boolean isEnded;
    private String winner;

    public Game(){
        this("", new HashSet<>(), new ArrayList<>(), false, "");
    }
    //Constructor
    public Game(Set<Player> players, List<Cell> cells, boolean isEnded, String winner) {
        this.id = UUID.randomUUID().toString();
        this.players = players;
        this.cells = cells;
        this.isEnded = isEnded;
        this.winner = winner;
    }

    public Game(String id, Set<Player> players, List<Cell> cells, boolean isEnded, String winner) {
        this.id = id;
        this.players = players;
        this.cells = cells;
        this.isEnded = isEnded;
        this.winner = winner;
    }

    public void startGame(String id, Player firstPlayer, List<Cell> cells){
        Game game = new Game(id,players,cells,false,"");
        newTurn(game, firstPlayer);
    }

    //starts a new turn
    public void newTurn(Game game, Player player) {
        while(!isEnded) {
                if(player.getPosition()!=63) {
                    player.rollDices(game);
                }
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
            players.add(new Player(username, 0, 0, false, 0, 0));

        listPlayers(getPlayers());
        return "Player added successfully";
    }

    //lists all the players in the game
    public String listPlayers(Set<Player> players) {
        String message = "Players: ";

        for (Player player : players) {
            message = message + player.getUsername();
        }

        return message;
    }

    //checks if a player doesn't already exist
    public boolean playerCheck(String username) {
        for (Player player : players) {
            if (player.getUsername() == username)
                return true;
        }

        return false;
    }

    //initializes the cells on the board
    public List<Cell> initializeBoard() {
        int i = 0;
        do {
            if (i != 5 && i != 6 && i != 9 && i != 13 && i != 18 && i != 23 && i != 27) {
                cells.add(new StandardCell(i, false));
                System.out.println(i);
            }

            i++;
        } while (i < 64);

        cells.add(new GooseCell(5, false));
        cells.add(new BridgeCell(6, false));
        cells.add(new GooseCell(9, false));
        cells.add(new GooseCell(13, false));
        cells.add(new GooseCell(18, false));
        cells.add(new GooseCell(23, false));
        cells.add(new GooseCell(27, false));

        return cells;
    }

    //adds a players to the list of players in the game
    public void addPlayer(Player player) {
        players.add(player);
    }

    //returns the players that occupy a certain cell on the board
    public List<Player> getCellOccupants(int position) {
        List<Player> occupants = new ArrayList<Player>();

        for (Player player : players) {
            if (player.getPosition() == position) {
                occupants.add(player);
            }
        }

        return occupants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void setEnded(boolean ended) {
        isEnded = ended;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
