package org.thegoosegame.servingwebcontent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheGooseGameController {

    @GetMapping("/")
    public String index() {
        return "THE GOOSE GAME!!";
    }

}
