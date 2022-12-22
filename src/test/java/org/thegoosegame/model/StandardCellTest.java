package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.thegoosegame.model.cell.StandardCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;
import org.thegoosegame.service.cell.CellService;
import org.thegoosegame.service.cell.DefaultCellService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
class StandardCellTest {
    @Mock
    Game game = new Game();
    @Mock
    Player player = new Player();
    @InjectMocks
    CellService cellService = new DefaultCellService(player);
    @InjectMocks
    GameService gameService = new GameService(game, cellService);
    @Mock
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

        gameService.initializeBoard(game);

        final Player player = new Player("username", game.getCells().get(0).getId());

        String moveResponse = "";
        standardCellTest.land(player, 2, 5, moveResponse);
        final int result = player.getCell();

        assertThat(result).isEqualTo(7);
    }
}
