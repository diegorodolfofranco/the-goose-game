package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thegoosegame.model.cell.StartCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

class StartCellTest {
    @Autowired
    GameService gameService;
    @Autowired
    StartCell startCellTest;

    @BeforeEach
    void setup() {
        startCellTest = new StartCell(0);
    }

    @Test
    void testLand() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "winner", 0, 0);
        startCellTest = new StartCell(0);

        gameService.initializeBoard();

        final Player player = new Player("username", game.getCells().get(0).getId());

        final int result = startCellTest.land(player, 0, 0);

        assertThat(result).isEqualTo(0);
    }
}
