package org.thegoosegame.model.cell;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

public interface Cell {
    String land(Player player, int firstDice, int secondDice, String moveResponse);

    int getId();

    void setPlayer(Player player);
}
