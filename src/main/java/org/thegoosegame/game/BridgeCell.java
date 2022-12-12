package org.thegoosegame.game;

public class BridgeCell implements Cell{
    private int id;
    private boolean isOccupied;

    public BridgeCell(int id, boolean isOccupied) {
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public int move(){
        return 0;
    }

    public int prank(){
        return 0;
    }

    public boolean isCellOccupied(){
        return isOccupied;
    }
}
