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
                UUID.randomUUID().toString(),
                new LinkedHashSet<>(),
                new ArrayList<>(),
                false,
                "Maria");

        assertNotNull(game);
        assertFalse(game.isEnded());
        assertEquals("Maria", game.getWinner(), "assertEquals: true");
    }
}