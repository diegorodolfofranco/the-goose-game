package org.thegoosegame.game;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private Player[] players;
    //private Set<Player> players = new HashSet<Player>();
    private Cell[] cells = new Cell[64];
    private boolean isEnded;
    private String winner;

    //Constructor
    public Game(Player[] players, Cell[] cells, boolean isEnded, String winner) {
        this.players = players;
        this.cells = cells;
        this.isEnded = isEnded;
        this.winner = winner;
    }

    //starts a new turn
    public void newTurn(){
        while(isEnded!=true){
            for (Player player : players) {
                player.rollDices();
            }
        }
    }

    //creates a new players after checking that the player doesn't already exist
    public String createPlayer(String username){
        Player player;

        if(playerCheck(username)==true)
            return username + ": already existing player.";
        else
            player = new Player(username);

        listPlayers(getPlayers());
        return "Player added successfully";
    }

    //lists all the players in the game
    public String listPlayers(Player[] players){
        String message = "Players: ";

        for(Player player : players){
            message = message + player.getUsername();
        }

        return message;
    }

    //checks if a player doesn't already exist
    public boolean playerCheck(String username){
        for (Player player: players) {
            if(player.getUsername() == username)
                return true;
        }

        return false;
    }

    //initializes the cells on the board
    public void initializeBoard(){
        for(int i=0; i<64; i++){
            cells[i] = new StandardCell(i,false);
        }

        cells[5] = new GooseCell(5, false);
        cells[6] = new BridgeCell(6,false);
        cells[9] = new GooseCell(9, false);
        cells[14] = new GooseCell(14, false);
        cells[18] = new GooseCell(18, false);
        cells[23] = new GooseCell(23, false);
        cells[27] = new GooseCell(27, false);
    }

    //adds a players to the list of players in the game
    public void addPlayer(Player player){
        players[players.length] = player;
    }

    //returns the players that occupy a certain cell on the board
    public Player[] getCellOccupants(int position){
        Player[] occupants = new Player[0];

        for (Player player: players) {
            if(player.getPosition() == position){
                occupants[occupants.length] = player;
            }
        }

        return occupants;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
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
