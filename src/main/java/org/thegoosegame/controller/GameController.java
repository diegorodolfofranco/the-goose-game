package org.thegoosegame.controller;

import org.springframework.web.bind.annotation.*;
import org.thegoosegame.repository.GameRepository;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameRepository gameRepository;
    public GameController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public String findAll(){
        return gameRepository.findAll();
    }
}
