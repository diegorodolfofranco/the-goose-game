package org.thegoosegame.model.cell;

import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

public interface Cell {
    String land(Game game, Player player, int dices, String moveResponse);

    int getId();
    void setPlayer(Player player);
}