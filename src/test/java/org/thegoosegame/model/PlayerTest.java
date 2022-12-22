package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thegoosegame.model.cell.Cell;
import org.thegoosegame.model.cell.StandardCell;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.service.GameService;
import org.thegoosegame.service.PlayerService;
import org.thegoosegame.service.cell.CellService;
import org.thegoosegame.service.cell.DefaultCellService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

@RunWith(MockitoJUnitRunner.class)
class PlayerTest {
    @Mock
    Game game = new Game();
    @Mock
    Player player = new Player();
    @InjectMocks
    PlayerService playerService = new PlayerService(game, player);
    @InjectMocks
    CellService cellService = new DefaultCellService(player);
    @InjectMocks
    GameService gameService = new GameService(game, cellService);
    @Mock
    Player playerTest;

    @BeforeEach
    void setup() {
        this.playerTest = playerTest;
    }
}
