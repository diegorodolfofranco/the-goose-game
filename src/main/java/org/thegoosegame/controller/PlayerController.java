package org.thegoosegame.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thegoosegame.game.Cell;
import org.thegoosegame.game.Player;

@RestController
public class PlayerController {
    @GetMapping("/player")
    public Player player(@RequestParam(value = "username") String username, String gameId, Cell cell) {
        return new Player(username, gameId, cell);
    }
}
