package org.thegoosegame.game;

public interface Cell {
    void move(Player player, int position);

    void prank(int prevPosition, int position);

    boolean isCellOccupied();

    int getId();

    void setId(int id);

    void setCellOccupied(boolean occupied);
}
