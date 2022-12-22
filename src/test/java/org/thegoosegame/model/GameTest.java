package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Autowired
    GameService gameService;
    @Autowired
    Game gameTest;

    @BeforeEach
    void setup() {
        gameTest = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "username", 0, 0);
    }

    @Test
    void testInitializeBoard() {
        gameService.initializeBoard();
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
        gameService.initializeBoard();

        final String result = gameService.createPlayer("username2");

        assertThat(result).isEqualTo("Player added successfully");
    }

    @Test
    void testPlayerCheck() {
        assertThat(gameService.playerCheck("username")).isTrue();
    }

    @Test
    void testListPlayers() {
        final Set<Player> players = new HashSet<>(Arrays.asList(new Player("username", 0)));

        final String result = gameService.listPlayers(players);

        assertThat(result).isEqualTo("Players:  username");
    }

    @Test
    void testNewTurnDicesToBeRolled() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "username", 0, 0);
        final Player currentPlayer = new Player("username", 0);

        gameService.initializeBoard();
        currentPlayer.setCell(game.getCells().get(0).getId());

        game.setFirstDice((int) (Math.random() * 6) + 1);
        game.setSecondDice((int) (Math.random() * 6) + 1);

        gameService.newTurn(currentPlayer);
    }

    @Test
    void testNewTurnDicesAlreadyRolled() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "username", 0, 0);
        final Player currentPlayer = new Player("username", 0);

        gameService.initializeBoard();
        currentPlayer.setCell(game.getCells().get(0).getId());

        int firstDice = 5;
        int secondDice = 3;

        gameService.newTurn(currentPlayer, firstDice, secondDice);
    }

    @Test
    void testMovePlayer() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "username", 0, 0);
        final Player player = new Player("username", 0);

        gameService.initializeBoard();
        player.setCell(game.getCells().get(0).getId());
        final int currentCell = player.getCell();

        game.setFirstDice(2);
        game.setSecondDice(1);

        gameService.movePlayer(game, player, currentCell);
    }

    @Test
    void testBounce() {
        assertThat(gameService.bounce(70)).isEqualTo(56);
    }
}
