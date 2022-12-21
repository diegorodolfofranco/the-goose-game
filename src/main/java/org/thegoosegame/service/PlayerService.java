package org.thegoosegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.cell.CellService;

import java.util.Set;

@Service
public class PlayerService {
    @Autowired
    private Game game;
    @Autowired
    private Player player;
    @Autowired
    private GameService gameService;

    @Autowired
    PlayerService(Game game, Player player, GameService gameService){
        this.game = game;
        this.player = player;
        this.gameService = gameService;
    }

    //implements the dice roll
    public void rollDices(Game game, Player player) {
        gameService.movePlayer(game, player, player.getCell());
    }
}
