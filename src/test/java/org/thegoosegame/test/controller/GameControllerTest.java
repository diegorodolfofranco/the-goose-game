package org.thegoosegame.test.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.thegoosegame.controller.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = GameController.class)
class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;
}
