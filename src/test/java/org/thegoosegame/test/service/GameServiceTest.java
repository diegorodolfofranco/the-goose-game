package org.thegoosegame.test.service;

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
import org.thegoosegame.service.GameService;
import org.thegoosegame.service.cell.CellService;
import org.thegoosegame.service.cell.DefaultCellService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        assertThat(cells.get(0).getId()).isZero();
        assertThat(cells.get(63).getId()).isEqualTo(63);
        assertThat(cells).hasSize(64);
    }

    @Test
    void testCreatePlayer() {
        gameService.initializeBoard(game);
        final String result = gameService.createPlayer("John");

        assertThat(result).isEqualTo("Players: [Player(username=John, cell=0)]");
        System.out.println(gameService.getGame().getPlayers());
        assertThat(((StartCell) gameService.getGame().getCells().get(0)).getPlayerByUsername("John").toString()).hasToString("Player(username=John, cell=0)");

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
        player = new Player("Mario", 0);

        gameService.initializeBoard(game);
        player.setCell(gameService.getGame().getCells().get(0).getId());

        gameService.getGame().setFirstDice((int) (Math.random() * 6) + 1);
        gameService.getGame().setSecondDice((int) (Math.random() * 6) + 1);

        String newTurnResponse = gameService.newTurn(player);

        int destinationCellId = gameService.getGame().getFirstDice() + gameService.getGame().getSecondDice();

        if(destinationCellId == 6)
            assertEquals("Mario moves from 0 to 12.", newTurnResponse);
        else if(destinationCellId == 5)
                assertEquals("Mario moves from 0 to " + destinationCellId
                        + ", The Goose. Mario moves again and goes to " + (destinationCellId * 2)
                        + ".", newTurnResponse);
            else if (destinationCellId == 9)
                    assertEquals("Mario moves from 0 to " + destinationCellId
                            + ", The Goose. Mario moves again and goes to " + (destinationCellId * 2)
                            + ", The Goose. ", newTurnResponse);
                else
                    assertEquals("Mario rolls " + gameService.getGame().getFirstDice() + ", "
                            + gameService.getGame().getSecondDice() + ". Mario moves from 0 to " + destinationCellId
                            + ".", newTurnResponse);
    }

    @Test
    void testNewTurnDicesAlreadyRolled() {
        player = new Player("Mario", 0);

        gameService.initializeBoard(game);
        player.setCell(game.getCells().get(0).getId());

        int firstDice = 5;
        int secondDice = 3;

        String newTurnResponse = gameService.newTurn(player, firstDice, secondDice);

        assertEquals("Mario rolls 5, 3. Mario moves from 0 to 8.", newTurnResponse);
    }

    @Test
    void testMovePlayer() {
        Player player = new Player("Mario", 0);
        gameService.initializeBoard(game);
        player.setCell(game.getCells().get(0).getId());
        final int currentCell = player.getCell();

        game.setFirstDice(2);
        game.setSecondDice(1);

        String moveResponse = gameService.movePlayer(game, player, currentCell);

        assertEquals("Mario rolls 2, 1. Mario moves from 0 to 3.", moveResponse);
    }

    @Test
    void testBounce() {
        assertThat(gameService.bounce(70)).isEqualTo(56);
    }
}
