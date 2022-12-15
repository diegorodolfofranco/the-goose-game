package org.thegoosegame.game;

public interface Cell {
    void move(Player player, int position);

    void prank(int prevPosition, int position);
}
