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
    public String landOnCell(Game game, Player player, Cell cell, String moveResponse) {
        int dices = game.getFirstDice() + game.getSecondDice();
        return cell.land(game, player, dices, moveResponse);
    }
}
