package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.cell.StandardCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

class PlayerTest {

    @Mock
    private Cell cell = new StandardCell("gameId", 0);

    private Player playerTest;

    @BeforeEach
    void setup() {
        playerTest = new Player("username", "gameId", cell.getId());
    }

    @Test
    void testRollDices() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", 0))),
                new ArrayList<>(), false, "winner", 1, 1);
        final Player currentPlayer = new Player("username", "gameId", cell.getId());

        game.initializeBoard();

        playerTest.rollDices(game, currentPlayer, 1, 1);
    }
}
