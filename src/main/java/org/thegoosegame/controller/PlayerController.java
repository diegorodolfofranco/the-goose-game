package org.thegoosegame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.repository.GameRepository;
import org.thegoosegame.repository.PlayerRepository;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository = new GameRepository();

    public PlayerController(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    //localhost:8080/players
    @GetMapping
    public Set<Player> findAll(){
        return playerRepository.findAll();
    }

    @GetMapping("/{username}")
    public Player findByUsername(@PathVariable String username) throws PlayerNotFoundException {
        return playerRepository.findByUsername(username);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Player create(@Valid @RequestBody Player player) {
        return playerRepository.create(player);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{username}")
    public void update(@RequestBody Player player, @PathVariable String username) {
        playerRepository.update(player, username);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) {
        playerRepository.delete(username);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/move/{username}/{firstDice}/{secondDice}")
    public void movePlayerDicesGiven(Game game, @PathVariable String username, @PathVariable int firstDice, @PathVariable int secondDice) throws PlayerNotFoundException {
        game.newTurn(game, playerRepository.findByUsername(username), firstDice, secondDice);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/move/{username}")
    public void movePlayer(Game game, @PathVariable String username) throws PlayerNotFoundException {
        game.newTurn(game, playerRepository.findByUsername(username));
    }
}