package org.thegoosegame.game;

public class GooseCell implements Cell{
    private int id;
    private boolean isOccupied;

    public GooseCell(int id, boolean isOccupied) {
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public void move(){

    }

    public int prank(){
        return 0;
    }

    public boolean isCellOccupied(){
        return isOccupied;
    }
}
