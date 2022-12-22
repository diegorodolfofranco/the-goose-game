package org.thegoosegame.model.cell;

import org.thegoosegame.model.player.Player;

public interface Cell {
    String land(Player player, int firstDice, int secondDice, String moveResponse);

    int getId();

    void setPlayer(Player player);
}
