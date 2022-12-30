package org.thegoosegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;

//import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public Game showGame(){
        return gameService.getGame();
    }

    @PutMapping
    public Game createGame(){
        if(gameService.getGame().getCells().size()!=64)
            gameService.initializeBoard(gameService.getGame());
        return gameService.getGame();
    }

    @GetMapping("/{username}")
    public Player findPlayerByUsername(@PathVariable String username) throws PlayerNotFoundException {
        return gameService.findPlayerByUsername(username);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/player")
    public ResponseEntity<String> createPlayer(@RequestBody String username) {
        createGame();
        return ResponseEntity.ok(gameService.createPlayer(username));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/move/{username}/{firstDice}/{secondDice}")
    public ResponseEntity<String> movePlayerWithDices(@PathVariable String username, @PathVariable int firstDice, @PathVariable int secondDice) throws PlayerNotFoundException {
        return ResponseEntity.ok(gameService.newTurn(gameService.findPlayerByUsername(username), firstDice, secondDice));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/move")
    public ResponseEntity<String> movePlayer(@RequestBody String username) throws PlayerNotFoundException {
        return ResponseEntity.ok(gameService.newTurn(gameService.findPlayerByUsername(username)));
    }
}
