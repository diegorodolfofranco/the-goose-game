package org.thegoosegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thegoosegame.controller.PlayerController;
import org.thegoosegame.model.Cell;
import org.thegoosegame.model.Game;
import org.thegoosegame.model.Player;
import org.thegoosegame.repository.PlayerRepository;

import java.util.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class TheGooseGameApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TheGooseGameApplication.class);
        app.run(args);
        Set<Player> players = new LinkedHashSet<>();
        List<Cell> cells = new ArrayList<>();
        Game game = new Game(players, cells, false, "");
        int firstDice, secondDice;

        //input scanner
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        PlayerRepository playerRepository = new PlayerRepository();
        PlayerController playerController = new PlayerController(playerRepository);

        //initializes the game board
        game.initializeBoard();

        //game
        while(!game.isEnded()) {
            if (command.length() < 4 || (command.substring(0, 4).compareTo("add ") != 0 && command.substring(0, 4).compareTo("move") != 0)){
                System.out.println("ERROR: wrong command!");
                command = scanner.nextLine();
            }
            else if (command.substring(0, 4).compareTo("add ") == 0) {
                System.out.println(game.createPlayer(command.substring(4), game));
                System.out.println(game.listPlayers(players));
                Player player = new Player(command.substring(4), game.getId(), 0);
                playerController.create(player);
                command = scanner.nextLine();
            } else if (command.substring(0, 4).compareTo("move")==0 && command.length()>5) {
                if (!command.contains(",")) {
                    String playerUsername = command.substring(5);
                    System.out.println(playerUsername);
                    Player player;

                    for (Player p : players) {
                        if (p.getUsername().equals(playerUsername)) {
                            player = p;
                            firstDice = (int) (Math.random() * 6) + 1;
                            secondDice = (int) (Math.random() * 6) + 1;
                            game.setFirstDice(firstDice);
                            game.setSecondDice(secondDice);
                            game.startGame(game, player);
                        }
                    }

                    command = scanner.nextLine();
                } else {
                    String playerUsername = command.substring(5, command.indexOf(" ", command.indexOf(" ") + 1));

                    boolean playerExists = game.playerCheck(playerUsername);
                    if(!playerExists)
                        System.out.print("ERROR: the player does not exist");
                    else{
                        Player player;
                        for (Player p : players) {
                            if (p.getUsername().equals(playerUsername)){
                                player = p;
                                firstDice = Integer.parseInt(command.substring(command.indexOf(',') - 1, command.indexOf(',')));
                                secondDice = Integer.parseInt(command.substring(command.indexOf(',')+1).trim());
                                if((firstDice>=1 && firstDice<=6) && (secondDice>=1 && secondDice<=6)) {
                                    game.setFirstDice(firstDice);
                                    game.setSecondDice(secondDice);
                                    game.startGame(game, player);
                                } else {
                                    System.out.println("ERROR: the value of one or both dices is incorrect");
                                    command = scanner.nextLine();
                                }
                            }
                        }
                    }

                    command = scanner.nextLine();
                }
            }
            else{
                System.out.println("ERROR: wrong move command!");
                command = scanner.nextLine();
            }
        }

        //prints the winner at the end of the game
        System.out.println("And the winner is... " + game.getWinner().toUpperCase() + "!!!");
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "THIS IS THE GOOSE GAME!";
    }
}
