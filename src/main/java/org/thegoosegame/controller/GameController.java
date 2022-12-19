package org.thegoosegame.controller;

import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.thegoosegame.model.*;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.game.Cell;
import org.thegoosegame.game.Game;
import org.thegoosegame.game.Player;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
//import org.thegoosegame.repository.*;

import java.util.*;

@RestController
public class GameController {
    //private GameRepository gameRepository;

    /*@GetMapping("/game")
    public Game game(){
        Game game = new Game(players, cells, isEnded, winner, firstDice, secondDice);
        game.initializeBoard();

        return game;
    }*/

    @GetMapping("/game")
    public Set<Player> addPlayer(Game game, @RequestParam(value="player") String username){
        game.initializeBoard();
        game.createPlayer(username, game);

        return game.getPlayers();
    }

    @GetMapping("/game/roll")
    public Game moveThePlayer(Game game, @RequestParam(value="player") String username, @RequestParam(value="firstDice") int firstDice, @RequestParam(value="secondDice") int secondDice) {
        boolean playerExists = game.playerCheck(username);

        Set<Player> players = game.getPlayers();
        Player player;

        if (playerExists) {
            for (Player p : players) {
                if (p.getUsername().equals(username)) {
                    player = p;
                    if ((firstDice >= 1 && firstDice <= 6) && (secondDice >= 1 && secondDice <= 6)) {
                        game.setFirstDice(firstDice);
                        game.setSecondDice(secondDice);
                        game.startGame(game, player);
                    }
                }
            }
        }
        return game;
    }

    @GetMapping("/game/game-rolls")
    public Game gameMovesThePlayer(Game game, @RequestParam(value="player") String username){
        boolean playerExists = game.playerCheck(username);
        Set<Player> players = game.getPlayers();
        Player player;
        int firstDice, secondDice;

        if(playerExists) {
            for (Player p : players) {
                if (p.getUsername().equals(username)) {
                    player = p;
                    firstDice = (int) (Math.random() * 6) + 1;
                    secondDice = (int) (Math.random() * 6) + 1;
                    game.setFirstDice(firstDice);
                    game.setSecondDice(secondDice);
                    game.startGame(game, player);
                }
            }
        }
        return game;
    }
}