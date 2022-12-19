package org.thegoosegame.game;

public interface Cell {
    int land(Game game, Player player, int firstDice, int secondDice);

    int getId();

    void setPlayer(Player player);
}
