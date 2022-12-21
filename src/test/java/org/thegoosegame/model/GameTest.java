package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game gameTest = new Game();

    @BeforeEach
    void setup() {
        gameTest = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", 0))),
                new ArrayList<>(), false, "username", 0, 0);
    }

    @Test
    void testStartGame() {
        final Player player = new Player("username", "gameId", 0);
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(player)),
                new ArrayList<>(), false, "username", 0, 0);

        game.initializeBoard();

        game.startGame(game, player);
    }

    @Test
    void testInitializeBoard() {
        gameTest.initializeBoard();
        List<Cell> cells = gameTest.getCells();

        Cell result = cells.get(0);
        assertThat(result.getId()).isEqualTo(0);
        result = cells.get(63);
        assertThat(result.getId()).isEqualTo(63);
    }

    @Test
    void testCreatePlayer() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList()),
                new ArrayList<>(), false, "winner", 0, 0);
        game.initializeBoard();

        final String result = game.createPlayer("username2", game);

        assertThat(result).isEqualTo("Player added successfully");
    }

    @Test
    void testPlayerCheck() {
        assertThat(gameTest.playerCheck("username")).isTrue();
    }

    @Test
    void testListPlayers() {
        final Set<Player> players = new HashSet<>(Arrays.asList(new Player("username", "gameId", 0)));

        final String result = gameTest.listPlayers(players);

        assertThat(result).isEqualTo("Players:  username");
    }

    @Test
    void testNewTurn() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", 0))),
                new ArrayList<>(), false, "username", 0, 0);
        final Player currentPlayer = new Player("username", "gameId", 0);

        game.initializeBoard();
        currentPlayer.setCell(game.getCells().get(0).getId());

        game.newTurn(game, currentPlayer, 0, 0);
    }

    @Test
    void testMovePlayer() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", 0))),
                new ArrayList<>(), false, "username", 0, 0);
        final Player player = new Player("username", "gameId", 0);

        game.initializeBoard();
        player.setCell(game.getCells().get(0).getId());
        final int currentCell = player.getCell();

        game.movePlayer(game, player, currentCell);
    }

    @Test
    void testBounce() {
        assertThat(gameTest.bounce(70)).isEqualTo(56);
    }
}
