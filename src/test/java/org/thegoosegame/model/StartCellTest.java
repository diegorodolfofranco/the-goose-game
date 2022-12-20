package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

class StartCellTest {

    private StartCell startCellTest;

    @BeforeEach
    void setup() {
        startCellTest = new StartCell("gameId", 0);
    }

    @Test
    void testLand() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", 0))),
                new ArrayList<>(), false, "winner", 0, 0);
        startCellTest = new StartCell("gameId", 0);

        game.initializeBoard();

        final Player player = new Player("username", "gameId", game.getCells().get(0).getId());

        final int result = startCellTest.land(game, player, 0, 0);

        assertThat(result).isEqualTo(0);
    }
}
