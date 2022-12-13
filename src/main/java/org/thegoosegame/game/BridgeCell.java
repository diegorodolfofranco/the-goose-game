package org.thegoosegame.game;

public class BridgeCell implements Cell{
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

    public int prank(){
        return 0;
    }

    public boolean isCellOccupied(){
        return isOccupied;
    }
}
