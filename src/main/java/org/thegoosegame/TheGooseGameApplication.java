package org.thegoosegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TheGooseGameApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TheGooseGameApplication.class);
        app.run(args);
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "THIS IS THE GOOSE GAME!";
    }
}
