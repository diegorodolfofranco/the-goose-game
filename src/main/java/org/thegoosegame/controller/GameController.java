package org.thegoosegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    GameController(GameService gameService){
        this.gameService = gameService;
    }
}
