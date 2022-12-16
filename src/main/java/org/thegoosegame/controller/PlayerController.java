package org.thegoosegame.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thegoosegame.game.Cell;
import org.thegoosegame.game.Game;
import org.thegoosegame.game.Player;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class PlayerController {
    Game game = new Game();
    String gameId = game.getId();

    //private final PlayerRepository repository;
    private Set<Player> players = new LinkedHashSet<>();

    /*public PlayerController(PlayerRepository repository){
        this.repository = repository;
    }*/

    @GetMapping("/player")
    public Player player(@RequestParam(value = "username") String username, Cell cell) {
        return new Player(username, cell);
    }
}
