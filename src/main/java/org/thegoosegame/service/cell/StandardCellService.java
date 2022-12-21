package org.thegoosegame.service.cell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.cell.BridgeCell;
import org.thegoosegame.model.cell.StandardCell;
import org.thegoosegame.model.cell.StartCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Service
@Qualifier("standardCellService")
public class StandardCellService {
    @Autowired
    Game game;
    @Autowired
    Player player;
    @Autowired
    StandardCell standardCell;

    StandardCellService(Game game, StandardCell standardCell, Player player){
        this.game = game;
        this.standardCell = standardCell;
        this.player = player;
    }

    //welcomes a player to the cell
    public int land(Game game, Player player, int firstDice, int secondDice){
        if(standardCell.getPlayer()!=null){
            System.out.println(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                    + ". " + player.getUsername() + " moves from " + player.getCell() + " to " + standardCell.getId()
                    + ". On " + standardCell.getId() + " there is " + standardCell.getPlayer().getUsername() + ", who moves to "
                    + player.getCell());

            Player prankedPlayer = standardCell.getPlayer();
            int prankDestinationCell = player.getCell();

            prankedPlayer.setCell(prankDestinationCell);
        }
        else
            System.out.println(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                    + ". " + player.getUsername() + " moves from " + player.getCell() + " to " + standardCell.getId()
                    + ".");

        player.setCell(standardCell.getId());

        return standardCell.getId();
    }
}
