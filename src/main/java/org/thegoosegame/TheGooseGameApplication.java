package org.thegoosegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TheGooseGameApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TheGooseGameApplication.class);
        app.run(args);
    }
}
