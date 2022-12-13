package org.thegoosegame.game;

public class BridgeCell implements Cell{
    private Game game;
    private int id;
    private boolean isOccupied;

    public BridgeCell(int id, boolean isOccupied) {
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public void move(){
        Player[] players = new Player[0];
        players = players[id].getGame().getCellOccupants(6);

        for (Player player : players) {
            player.setPrevPosition(player.getPosition());
            player.setPosition(12);
        }
    }

    public void prank(int prevPosition, int position){
        Player[] occupants = getGame().getCellOccupants(position);

        for (Player player : occupants)
            player.setPosition(prevPosition);
    }

    public boolean isCellOccupied(){
        return isOccupied;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
