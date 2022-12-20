package org.thegoosegame.repository;

import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.Game;
import org.thegoosegame.model.Player;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PlayerRepository {
    Set<Player> players = new LinkedHashSet<>();
    Game game = new Game(players,new ArrayList<>(),false,"");
    int cell;

    public PlayerRepository() {
        game.initializeBoard();
        cell = game.getCells().get(0).getId();
        Player player = new Player(
                "Pippo",
                game.getId(),
                cell);
        players.add(player);
        game.getCells().get(cell).setPlayer(player);
    }

    public Set<Player> findAll() {
        return players;
    }

    public Player findByUsername(String username) throws PlayerNotFoundException {
        return players.stream().filter(stream -> stream.getUsername().equals(username)).findFirst().orElseThrow(PlayerNotFoundException::new);
    }

    public Player create(Player player) {
        players.add(player);
        return player;
    }

    public void update(Player player, String username) {
        Player existing = players.stream().filter(s -> s.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));
        List<Player> playersList = new ArrayList<>(players);
        int i = playersList.indexOf(existing);
        playersList.set(i, player);
        players = new LinkedHashSet<>(playersList);
    }

    public void delete(String username) {
        players.removeIf(stream -> stream.getUsername().equals(username));
    }
}
