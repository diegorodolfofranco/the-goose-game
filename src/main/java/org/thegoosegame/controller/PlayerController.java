package org.thegoosegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.model.Player;
import org.thegoosegame.repository.*;

import java.util.Optional;
import java.util.Set;

@RestController
@EnableAutoConfiguration
@RequestMapping("/player")
public class PlayerController {

    private PlayerRepository playerRepository;

    @GetMapping
    public Set<Player> findAllPlayers() {
        return (Set<Player>) playerRepository.findAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<Player> findPlayerByUsername(@PathVariable(value = "username") String username) {
        {
            Optional<Player> player = playerRepository.findById(username);

            if (player.isPresent())
                return ResponseEntity.ok().body(player.get());
            else
                return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Player savePlayer(@Validated @RequestBody Player player) {
            return playerRepository.save(player);
    }

    /*@GetMapping("/player")
    public Player player(@RequestParam(value = "username") String username, String gameId, Cell cell) {
        return new Player(username, gameId, cell);
    }*/
}
