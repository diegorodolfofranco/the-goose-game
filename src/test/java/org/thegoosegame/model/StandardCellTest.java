package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thegoosegame.model.cell.BridgeCell;
import org.thegoosegame.model.cell.StandardCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;
import org.thegoosegame.service.cell.BridgeCellService;
import org.thegoosegame.service.cell.StandardCellService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

class StandardCellTest {
    @Autowired
    GameService gameService;
    @Autowired
    StandardCellService standardCellService;
    @Autowired
    StandardCell standardCellTest;

    @BeforeEach
    void setup() {
        standardCellTest = new StandardCell(1);
    }

    @Test
    void testLand() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "winner", 0, 0);
        standardCellTest = new StandardCell(7);

        gameService.initializeBoard();

        final Player player = new Player("username", game.getCells().get(0).getId());

        final int result = standardCellService.land(game, player, 2, 5);

        assertThat(result).isEqualTo(7);
    }
}
