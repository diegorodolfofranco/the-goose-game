package org.thegoosegame.game;

public interface Cell {
    public void move();

    public void prank(int prevPosition, int position);

    public boolean isCellOccupied();
}
