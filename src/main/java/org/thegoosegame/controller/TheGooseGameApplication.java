package org.thegoosegame.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TheGooseGameApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TheGooseGameApplication.class);
        app.run(args);
    }

    @GetMapping("/welcome")
    public String welcome() {
        return String.format("THIS IS THE GOOSE GAME!");
    }
}
