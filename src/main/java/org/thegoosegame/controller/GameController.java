package org.thegoosegame.controller;

import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thegoosegame.model.*;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.game.Cell;
import org.thegoosegame.game.Game;
import org.thegoosegame.game.Player;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.thegoosegame.repository.*;

import java.util.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameRepository gameRepository;

    /*@GetMapping("/game")
    public Game game(){
        Game game = new Game(players, cells, isEnded, winner, firstDice, secondDice);
        game.initializeBoard();

        return game;
    }*/

    @GetMapping("/game")
    public Set<Player> addPlayer(Game game, @RequestParam(value="player") String username){
        game.createPlayer(username, game);
        Set<Player> players = game.getPlayers();

        return players;
    }
}