package org.thegoosegame.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void create_new_game() {
        Game game = new Game(
                new LinkedHashSet<>(),
                new ArrayList<>(),
                false,
                "Maria",
                0,
                0);

        assertNotNull(game);
        assertFalse(game.isEnded());
        assertEquals("Maria", game.getWinner(), "assertEquals: true");
    }
}