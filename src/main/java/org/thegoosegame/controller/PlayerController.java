package org.thegoosegame.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thegoosegame.game.Cell;
import org.thegoosegame.game.Game;
import org.thegoosegame.game.Player;
import org.thegoosegame.repository.PlayerRepository;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class PlayerController {
    Game game = new Game();
    String gameId = game.getId();
    private String username;
    private int position = 0;
    private int prevPosition = 0;
    private boolean hasWon;
    private int firstDice;
    private int secondDice;

    //private final PlayerRepository repository;
    private Set<Player> players = new LinkedHashSet<>();

    /*public PlayerController(PlayerRepository repository){
        this.repository = repository;
    }*/

    @GetMapping("/player")
    public Player player(@RequestParam(value = "username") String username, Cell cell){
        return new Player(username, cell);
    }

    /*@GetMapping("players")
    public Set<Player> findAllPlayers(){
    }*/
}
