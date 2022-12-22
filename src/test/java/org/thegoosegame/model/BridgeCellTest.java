package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thegoosegame.model.cell.BridgeCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import org.thegoosegame.service.*;

@Component
class BridgeCellTest {

    @Autowired
    GameService gameService;
    @Autowired
    BridgeCell bridgeCellTest;

    @BeforeEach
    void setup() {
        bridgeCellTest = new BridgeCell(6);
    }

    @Test
    void testLand() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "winner", 0, 0);
        bridgeCellTest = new BridgeCell(6);

        gameService.initializeBoard();

        final Player player = new Player("username", game.getCells().get(0).getId());

        final int result = bridgeCellTest.land(player, 2, 4);

        assertThat(result).isEqualTo(12);
    }
}
