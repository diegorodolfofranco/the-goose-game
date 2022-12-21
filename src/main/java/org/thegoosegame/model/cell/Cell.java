package org.thegoosegame.model.cell;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Service
public interface Cell {
    int getId();

    void setPlayer(Player player);
}
