package org.thegoosegame.model.cell;

import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

public interface Cell {
    int land(Game game, Player player, int firstDice, int secondDice);

    int getId();

    void setPlayer(Player player);
}
