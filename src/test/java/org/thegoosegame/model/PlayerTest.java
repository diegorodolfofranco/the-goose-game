package org.thegoosegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.thegoosegame.model.player.Player;

@RunWith(MockitoJUnitRunner.class)
class PlayerTest {
    @Mock
    Player player = new Player();

    @BeforeEach
    void setup() {
        this.player = new Player("username1",0);
    }
}
