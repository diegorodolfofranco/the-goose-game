package org.thegoosegame.service.cell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Service
public class DefaultCellService implements CellService {
    @Autowired
    Player player;

    @Autowired
    public DefaultCellService(Player player){
        this.player = player;
    }

    @Override
    public String landOnCell(Game game, Cell cell, String moveResponse) {
        return cell.land(player, game.getFirstDice(), game.getSecondDice(), moveResponse);
    }
}
