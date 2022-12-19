package org.thegoosegame.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

class GooseCellTest {

    private GooseCell gooseCellTest;

    @BeforeEach
    void setup() {
        gooseCellTest = new GooseCell("gameId", 0);
    }

    @Test
    void testLand() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", null))),
                new ArrayList<>(), false, "winner", 0, 0);
        gooseCellTest = new GooseCell("gameId", 5);

        game.initializeBoard();

        final Player player = new Player("username", "gameId", game.getCells().get(0));

        final int result = gooseCellTest.land(game, player, 2, 3);

        assertThat(result).isEqualTo(10);
    }
}