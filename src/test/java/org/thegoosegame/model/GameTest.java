package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;
import org.thegoosegame.service.cell.CellService;
import org.thegoosegame.service.cell.DefaultCellService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
class GameTest {
    @Mock
    Game game = new Game();
    @Mock
    Player player = new Player();
    @InjectMocks
    CellService cellService = new DefaultCellService(player);
    @InjectMocks
    GameService gameService = new GameService(game, cellService);

    @BeforeEach
    void setup() {
        this.game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "username", 0, 0);
    }

    @Test
    void testInitializeBoard() {
        gameService.initializeBoard(game);
        List<Cell> cells = game.getCells();

        Cell result = cells.get(0);
        assertThat(result.getId()).isEqualTo(0);
        result = cells.get(63);
        assertThat(result.getId()).isEqualTo(63);
    }

    @Test
    void testCreatePlayer() throws PlayerNotFoundException {
        setup();
        gameService.initializeBoard(game);
        System.out.println(game);

        final String result = gameService.createPlayer("username2");

        assertThat(result).isEqualTo("[" + gameService.findPlayerByUsername("username2") + "]");
    }

    @Test
    void testPlayerCheck() {
        player.setUsername("username");

        assertThat(gameService.playerCheck("username")).isFalse();
    }

    @Test
    void testListPlayers() {
        final Set<Player> players = new HashSet<>(Arrays.asList(new Player("username", 0)));

        final String result = gameService.listPlayers(players);

        assertThat(result).isEqualTo("Players:  username");
    }

    @Test
    void testNewTurnDicesToBeRolled() {
        player = new Player("username", 0);

        gameService.initializeBoard(game);
        player.setCell(game.getCells().get(0).getId());

        game.setFirstDice((int) (Math.random() * 6) + 1);
        game.setSecondDice((int) (Math.random() * 6) + 1);

        gameService.newTurn(player);
    }

    @Test
    void testNewTurnDicesAlreadyRolled() {
        player = new Player("username", 0);

        gameService.initializeBoard(game);
        player.setCell(game.getCells().get(0).getId());

        int firstDice = 5;
        int secondDice = 3;

        gameService.newTurn(player, firstDice, secondDice);
    }

    @Test
    void testMovePlayer() {
        gameService.initializeBoard(game);
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
