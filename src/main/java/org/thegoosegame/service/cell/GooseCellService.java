package org.thegoosegame.service.cell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.cell.BridgeCell;
import org.thegoosegame.model.cell.GooseCell;
import org.thegoosegame.model.cell.StartCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Service
@Qualifier("gooseCellService")
public class GooseCellService {
    @Autowired
    Game game;
    @Autowired
    Player player;
    @Autowired
    GooseCell gooseCell;
    @Autowired
    GooseCellService gooseCellService;

    GooseCellService(Game game, GooseCell gooseCell, Player player){
        this.game = game;
        this.gooseCell = gooseCell;
        this.player = player;
    }

    //welcomes the player to the cell
    public int land(Game game, Player player, int firstDice, int secondDice) {
        int destination = gooseCell.getId() + firstDice + secondDice;

        if(destination!=5 && destination!=9 && destination!= 13 && destination!= 18 && destination!=23 && destination!=27){
            System.out.println(player.getUsername() + " moves from " + player.getCell() + " to " + gooseCell.getId()
                    + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination + ".");
        }
        else {
            System.out.println(player.getUsername() + " moves from " + player.getCell() + " to " + gooseCell.getId()
                    + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination + ", The Goose. ");
            int newDestination = destination + firstDice + secondDice;
            land(game, player, firstDice, secondDice);
        }

        player.setCell(gooseCell.getId());

        return destination;
    }
}
