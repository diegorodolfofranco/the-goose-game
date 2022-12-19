package org.thegoosegame.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

class StandardCellTest {

    private StandardCell standardCellTest;

    @BeforeEach
    void setup() {
        standardCellTest = new StandardCell("gameId", 0);
    }

    @Test
    void testLand() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", null))),
                new ArrayList<>(), false, "winner", 0, 0);
        standardCellTest = new StandardCell("gameId", 7);

        game.initializeBoard();

        final Player player = new Player("username", "gameId", game.getCells().get(0));

        final int result = standardCellTest.land(game, player, 2, 5);

        assertThat(result).isEqualTo(7);
    }
}