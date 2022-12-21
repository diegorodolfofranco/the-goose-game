package org.thegoosegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheGooseGameApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TheGooseGameApplication.class);
        app.run(args);
    }
}
