package org.thegoosegame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.Player;
import org.thegoosegame.repository.PlayerRepository;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerRepository playerRepository;

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
}
