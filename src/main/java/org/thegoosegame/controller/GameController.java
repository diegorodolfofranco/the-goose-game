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
    private int firstDice;
    private int secondDice;

    @GetMapping("/game")
    public Game game(@RequestParam(value="player") String username){
        //players.add(new Player(username));
        Game game = new Game(players, cells, isEnded, winner,firstDice,secondDice);
        game.initializeBoard();

        return game;
    }
}