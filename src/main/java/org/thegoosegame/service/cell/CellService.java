package org.thegoosegame.service.cell;

import org.springframework.stereotype.Service;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Service
public interface CellService {


    public String landOnCell(Game game, Player player, Cell cell, String moveResponse);
}
