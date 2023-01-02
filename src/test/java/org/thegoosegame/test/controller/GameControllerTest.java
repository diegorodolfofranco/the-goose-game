package org.thegoosegame.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thegoosegame.controller.GameController;
import org.thegoosegame.exception.PlayerNotFoundException;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.cell.StartCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    @Mock
    private GameService gameService;
    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void testShowGame() {
        Game game = new Game();

        when(gameService.getGame()).thenReturn(game);
        assertEquals(game, gameController.showGame());
    }

    @Test
    void testCreateGame() {
        Game game = new Game();

        when(gameService.getGame()).thenReturn(game);
        gameController.createGame();
        verify(gameService, times(1)).initializeBoard(game);
    }

    @Test
    void testCreateGameEmptyBoard() {
        Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("Mario", 0))),
                Arrays.asList(new Cell[64]), false, "", 0, 0);

        when(gameService.getGame()).thenReturn(game);
        gameController.createGame();
        verify(gameService, never()).initializeBoard(game);
    }

    @Test
    void findPlayerByUsernamePlayerDoesntAlreadyExist() throws PlayerNotFoundException {
        when(gameService.findPlayerByUsername(anyString())).thenThrow(new PlayerNotFoundException());
        assertThrows(PlayerNotFoundException.class, () -> gameController.findPlayerByUsername("Mario"));
    }

    @Test
    void findPlayerByUsernamePlayerAlreadyExists() throws PlayerNotFoundException {
        Game game = new Game();

        game.getCells().add(new StartCell(0));
        game.getPlayers().add(new Player("Mario", 0));
        when(gameService.findPlayerByUsername("Mario")).thenReturn(game.getPlayers().iterator().next());

        Player player = gameController.findPlayerByUsername("Mario");

        assertEquals("Mario", player.getUsername());
    }

    @Test
    void testCreatePlayerWhenPlayerDoesntExist() {
        when(gameService.createPlayer("Mario")).thenReturn("Players: Mario");
        when(gameService.getGame()).thenReturn(new Game(new LinkedHashSet<Player>(Arrays.asList(new Player("Mario", 0))), Arrays.<Cell>asList(new StartCell(new LinkedHashSet<Player>(Arrays.asList(new Player("Mario", 0))), 0)), false, "", 0, 0));
        String response = gameController.createPlayer("Mario").toString();
        assertEquals("<200 OK OK,Players: Mario,[]>", response);
    }

    @Test
    void testCreatePlayerWhenPlayerAlreadyExists() {
        when(gameService.createPlayer("Mario")).thenReturn("Mario: already existing player.");
        when(gameService.getGame()).thenReturn(new Game(new LinkedHashSet<Player>(Arrays.asList(new Player("Mario", 0))), Arrays.<Cell>asList(new StartCell(new LinkedHashSet<Player>(Arrays.asList(new Player("Mario", 0))), 0)), false, "", 0, 0));
        String response = gameController.createPlayer("Mario").toString();
        assertEquals("<200 OK OK,Mario: already existing player.,[]>", response);
    }

    @Test
    void testMovePlayerWithDices() throws PlayerNotFoundException {
        Player player = new Player("Mario", 0);

        when(gameService.newTurn(player, 2, 2)).thenReturn("Mario rolls 2, 2. Mario moves from 0 to 4.");
        when(gameService.findPlayerByUsername("Mario")).thenReturn(player);
        String response = gameController.movePlayerWithDices("Mario", 2, 2).toString();
        assertEquals("<200 OK OK,Mario rolls 2, 2. Mario moves from 0 to 4.,[]>", response);
    }

    @Test
    void testMovePlayerWithDicesIncorrectDices() throws PlayerNotFoundException {
        Player player = new Player("Mario", 0);

        when(gameService.newTurn(player, 3, 7)).thenReturn("ERROR: Incorrect dices entered.");
        when(gameService.findPlayerByUsername("Mario")).thenReturn(player);
        String response = gameController.movePlayerWithDices("Mario", 3, 7).toString();
        assertEquals("<200 OK OK,ERROR: Incorrect dices entered.,[]>", response);
    }
}