package org.thegoosegame.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thegoosegame.game.Cell;
import org.thegoosegame.game.Game;
import org.thegoosegame.game.Player;

import java.util.*;

@RestController
public class GameController {

    private final String id = UUID.randomUUID().toString();
    private final Set<Player> players = new LinkedHashSet<>();
    private final List<Cell> cells = new ArrayList<>();
    private boolean isEnded;
    private String winner;

    @GetMapping("/game")
    public Game game(@RequestParam(value="player") String username){
        Game game = new Game(id, players, cells, isEnded, winner);
        players.add(new Player(game.getId(),username));
        game.initializeBoard();

        return game;
    }
}