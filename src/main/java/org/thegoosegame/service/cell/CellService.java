package org.thegoosegame.service.cell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Service
public interface CellService {
    //public int land(Game game, Player player, int firstDice, int secondDice);

    public String landOnCell(Game game, Player player, Cell cell, String moveResponse);
}
