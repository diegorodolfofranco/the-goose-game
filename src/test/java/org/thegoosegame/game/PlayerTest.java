package org.thegoosegame.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Mock
    private Cell cell = new StandardCell("gameId", 0);

    private Player playerTest;

    @BeforeEach
    void setup() {
        playerTest = new Player("username", "gameId", cell);
    }

    @Test
    void testRollDices() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", null))),
                new ArrayList<>(), false, "winner", 1, 1);
        final Player currentPlayer = new Player("username", "gameId", cell);

        game.initializeBoard();

        playerTest.rollDices(game, currentPlayer, 1, 1);
    }
}
