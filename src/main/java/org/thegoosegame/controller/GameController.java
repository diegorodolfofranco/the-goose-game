package org.thegoosegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashSet;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    Game game;

    @PostConstruct
    void setUp() {
        System.out.println("Controller ready");
    }

    @GetMapping
    public Game showGame(){
        return game;
    }

    @PutMapping
    public Game createGame(){
        gameService.initializeBoard();
        return game;
    }

    @GetMapping("/{username}")
    public Player findPlayerByUsername(@PathVariable String username) throws PlayerNotFoundException {
        return gameService.findPlayerByUsername(username);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/player")
    public String createPlayer(@RequestBody String username) {
        createGame();
        return gameService.createPlayer(username);
    }

    @PutMapping("/move/{username}/{firstDice}/{secondDice}")
    public ResponseEntity<String> movePlayerWithDices(@PathVariable String username, @PathVariable int firstDice, @PathVariable int secondDice) throws PlayerNotFoundException {
        return ResponseEntity.ok(gameService.newTurn(gameService.findPlayerByUsername(username), firstDice, secondDice));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/move/{username}")
    public String movePlayer(@RequestBody String username) throws PlayerNotFoundException {
        return gameService.newTurn(gameService.findPlayerByUsername(username));
    }
}
