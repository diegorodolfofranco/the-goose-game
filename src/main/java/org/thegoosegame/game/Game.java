package org.thegoosegame.game;

public class Game {
    private Player[] players;
    private Cell[] cells;
    private boolean isEnded;
    private String winner;

    public void newTurn(){

    }

    public void createPlayer(String username){

    }

    public String listPlayers(Player[] players){
        return "";
    }

    public String showPlayerMovement(int oldPosition, int newPosition){
        return "";
    }

    public boolean playerCheck(String username){
        return false;
    }

    public void initializeBoard(Cell[] cells){

    }

    public void addPlayer(Player player){

    }

    /*public Player[] getCellOccupants(int position){

    }*/

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
