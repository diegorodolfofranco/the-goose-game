package org.thegoosegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    Game game;
    @Autowired
    private final GameService gameService;

    @Autowired
    GameController(Game game, GameService gameService){
        this.game = game;
        this.gameService = gameService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Game create(Game game) {
        return game;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(Game game) {
        game = null;
    }

    @GetMapping
    public Set<Player> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{username}")
    public Player findPlayerByUsername(@PathVariable String username) throws PlayerNotFoundException {
        return gameService.findPlayerByUsername(username);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String createPlayer(@PathVariable Player player) {
        return gameService.createPlayer(player.getUsername(), game);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/move/{username}/{firstDice}/{secondDice}")
    public String movePlayerWithDices(@Valid @RequestBody Player player) {
        return gameService.createPlayer(player.getUsername(), game);
    }
}
