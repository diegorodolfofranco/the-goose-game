package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.thegoosegame.model.cell.BridgeCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeCellTest {

    private BridgeCell bridgeCellTest;

    @BeforeEach
    void setup() {
        bridgeCellTest = new BridgeCell("gameId", 0);
    }

    @Test
    void testLand() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", "gameId", 0))),
                new ArrayList<>(), false, "winner", 0, 0);
        bridgeCellTest = new BridgeCell("gameId", 6);

        game.initializeBoard();

        final Player player = new Player("username", "gameId", game.getCells().get(0).getId());

        final int result = bridgeCellTest.land(game, player, 2, 4);

        assertThat(result).isEqualTo(12);
    }
}