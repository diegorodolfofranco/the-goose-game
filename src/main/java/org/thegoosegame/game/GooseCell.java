package org.thegoosegame.game;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GooseCell implements Cell {
    String gameId;
    Player player;
    private int id;

    public GooseCell(String gameId, int id) {
        this.gameId = gameId;
        this.id = id;
    }

    public int land(Game game, Player player, int firstDice, int secondDice) {
        int destination = getId() + firstDice + secondDice;

        if(destination!=5 && destination!=9 && destination!= 13 && destination!= 18 && destination!=23 && destination!=27){
        System.out.println(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                + ". " + player.getUsername() + " moves from " + player.getCell().getId() + " to " + getId()
                + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination);
        }
        else {
            System.out.println(player.getUsername() + " moves again and goes to " + destination + ", The Goose.");
            int newDestination = destination + firstDice + secondDice;
            game.getCells().get(newDestination).land(game, player, firstDice, secondDice);
        }

        player.setCell(this);

        return destination;
    }

    public int getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }
}
