package org.thegoosegame.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;

@RestController
@RequestMapping("")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public String welcome(){
        return "WELCOME TO THE GOOSE GAME!";
    }

    @GetMapping("/game")
    public Game showGame(){
        return gameService.getGame();
    }

    @PutMapping("/game")
    public Game createGame(){
        if(gameService.getGame().getCells().size()!=64)
            gameService.initializeBoard(gameService.getGame());
        return gameService.getGame();
    }

    @GetMapping("/game/player")
    public Player findPlayerByUsername(@RequestBody String username) throws PlayerNotFoundException {
        return gameService.findPlayerByUsername(username);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/game/player")
    public ResponseEntity<String> createPlayer(@RequestBody String username) {
        createGame();
        return ResponseEntity.ok(gameService.createPlayer(username));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/game/move")
    public ResponseEntity<String> movePlayerWithDices(@RequestBody String requestBody) throws PlayerNotFoundException {
        JSONObject jsonRequestBody = new JSONObject(requestBody);
        String username = jsonRequestBody.getString("username");
        int firstDice = jsonRequestBody.getInt("firstDice");
        int secondDice = jsonRequestBody.getInt("secondDice");

        return ResponseEntity.ok(gameService.newTurn(gameService.findPlayerByUsername(username), firstDice, secondDice));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/game/move/nodices")
    public ResponseEntity<String> movePlayer(@RequestBody String username) throws PlayerNotFoundException {
        return ResponseEntity.ok(gameService.newTurn(gameService.findPlayerByUsername(username)));
    }
}
