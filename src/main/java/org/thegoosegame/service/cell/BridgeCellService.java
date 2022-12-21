package org.thegoosegame.service.cell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.cell.BridgeCell;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.cell.StartCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Service
@Qualifier("bridgeCellService")
public class BridgeCellService {

    @Autowired
    Game game;
    @Autowired
    Player player;
    @Autowired
    BridgeCell bridgeCell;

    BridgeCellService(Game game, BridgeCell bridgeCell, Player player){
        this.game = game;
        this.bridgeCell = bridgeCell;
        this.player = player;
    }

    //welcomes a player to the cell
    public int land(Game game, Player player, int firstDice, int secondDice){
        System.out.println(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                + ". " + player.getUsername() + " moves from " + player.getCell() + " to 12.");

        player.setCell(bridgeCell.getId());

        return 12;
    }
}
