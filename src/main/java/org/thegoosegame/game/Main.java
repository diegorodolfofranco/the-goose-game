package org.thegoosegame.game;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Set<Player> players = new LinkedHashSet<>();
        List<Cell> cells = new ArrayList<>();
        Game game = new Game(players, cells, false, "");
        boolean dicesRolled;
        int firstDice, secondDice;

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        game.initializeBoard();

        while(!game.isEnded()) {
            if (command.length() < 4 || (command.substring(0, 4).compareTo("add ") != 0 && command.substring(0, 4).compareTo("move") != 0)){
                System.out.println("ERROR: wrong command!");
                command = scanner.nextLine();
            }
            else if (command.substring(0, 4).compareTo("add ") == 0) {
                System.out.println(game.createPlayer(command.substring(4)));
                System.out.println(game.listPlayers(players));
                command = scanner.nextLine();
                } else if (command.substring(0, 4).compareTo("move") == 0 && command.length()>5) {
                    if (!command.contains(",")) {
                        dicesRolled = true;
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
                                game.startGame(player, dicesRolled);
                            }
                        }

                        command = scanner.nextLine();
                    } else {
                        dicesRolled = false;
                        String playerUsername = command.substring(5, command.indexOf(" ", command.indexOf(" ") + 1));

                        boolean playerExists = game.playerCheck(playerUsername);
                        if(!playerExists)
                            System.out.print("ERROR: the player does not exist");
                        else{
                            Player player;
                            for (Player p : players) {
                                if (p.getUsername().equals(playerUsername)){
                                    player = p;
                                    firstDice = Integer.parseInt(command.substring(command.indexOf(',') - 1), command.indexOf(','));
                                    secondDice = Integer.parseInt(command.substring(command.indexOf(',')));
                                    game.setFirstDice(firstDice);
                                    game.setSecondDice(secondDice);
                                    game.startGame(player, dicesRolled);
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

        System.out.println("And the winner is... " + game.getWinner().toUpperCase() + "!!!");
    }
}