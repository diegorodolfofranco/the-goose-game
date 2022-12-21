package org.thegoosegame.service.cell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.cell.StartCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;

@Service
@Qualifier("startCellService")
public class StartCellService {
    @Autowired
    Game game;
    @Autowired
    StartCell startCell;
    @Autowired
    Player player;

    @Autowired
    StartCellService(Game game, StartCell startCell, Player player){
        this.game = game;
        this.startCell = startCell;
        this.player = player;
    }

    //welcomes a player to the cell
    public int land(Game game, Player player, int firstDice, int secondDice){
        player.setCell(startCell.getId());
        return 0;
    }
}
