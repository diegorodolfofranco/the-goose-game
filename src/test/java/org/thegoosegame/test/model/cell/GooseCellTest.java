package org.thegoosegame.test.model.cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.thegoosegame.model.cell.GooseCell;
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
class GooseCellTest {
    @Mock
    Game game = new Game();
    @Mock
    Player player = new Player();
    @InjectMocks
    CellService cellService = new DefaultCellService(player);
    @InjectMocks
    GameService gameService = new GameService(game, cellService);
    @Mock
    GooseCell gooseCellTest;

    @BeforeEach
    void setup() {
        gooseCellTest = new GooseCell(9);
    }

    @Test
    void testLand() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "winner", 0, 0);
        gooseCellTest = new GooseCell(5);

        gameService.initializeBoard(game);

        final Player player = new Player("username", game.getCells().get(0).getId());

        String moveResponse = "";
        gooseCellTest.land(game, player, 5, moveResponse);
        final int result = player.getCell();

        assertThat(result).isEqualTo(10);
    }
}
