package org.thegoosegame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.cell.StartCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.cell.CellService;
import org.thegoosegame.service.cell.DefaultCellService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
class GameServiceTest {
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

        assertThat(cells.get(0).getId()).isEqualTo(0);
        assertThat(cells.get(63).getId()).isEqualTo(63);
        assertThat(cells.size()).isEqualTo(64);
    }

    @Test
    void testCreatePlayer() {
        gameService.initializeBoard(game);
        final String result = gameService.createPlayer("John");

        assertThat(result).isEqualTo("Players: [Player(username=John, cell=0)]");
        System.out.println(gameService.getGame().getPlayers());
        assertThat(((StartCell) gameService.getGame().getCells().get(0)).getPlayerByUsername("John").toString()).isEqualTo("Player(username=John, cell=0)");

        assertThat(gameService.createPlayer("John")).isEqualTo("John: already existing player.");
    }

    @Test
    void testPlayerCheck() {
        player.setUsername("username");
        assertThat(gameService.playerCheck("username")).isFalse();
        gameService.createPlayer("username");
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
