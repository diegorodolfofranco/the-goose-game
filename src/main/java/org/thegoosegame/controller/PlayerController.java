package org.thegoosegame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/move/{username}/{firstDice}/{secondDice}")
    public void movePlayerDicesGiven(Game game, @PathVariable String username, @PathVariable int firstDice, @PathVariable int secondDice) throws PlayerNotFoundException {
        //game.newTurn(game, playerRepository.findByUsername(username), firstDice, secondDice);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/move/{username}")
    public void movePlayer(Game game, @PathVariable String username) throws PlayerNotFoundException {
        //game.newTurn(game, playerRepository.findByUsername(username));
    }
}