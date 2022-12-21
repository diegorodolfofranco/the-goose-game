package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.cell.StandardCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;
import org.thegoosegame.service.PlayerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

class PlayerTest {
    @Autowired
    PlayerService playerService;
    @Autowired
    GameService gameService;
    @Autowired
    Player playerTest;
    @Autowired
    Cell cell;

    @BeforeEach
    void setup() {
        playerTest = new Player("username", cell.getId());
    }

    @Test
    void testRollDices() {
        final Game game = new Game(new LinkedHashSet<>(Arrays.asList(new Player("username", 0))),
                new ArrayList<>(), false, "winner", 1, 1);
        final Player currentPlayer = new Player("username", cell.getId());

        gameService.initializeBoard();

        playerService.rollDices(game, currentPlayer);
    }
}
