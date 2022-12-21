package org.thegoosegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;
import org.thegoosegame.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    Player player;
    @Autowired
    private final PlayerService playerService;

    @Autowired
    PlayerController(Game game, PlayerService playerService){
        this.player = player;
        this.playerService = playerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Player create(Player player) {

        return player;
    }
}