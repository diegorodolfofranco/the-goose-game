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

    public int land(Player player) {
        Game game = new Game();
        //Cell cell = this;

        int destination = getId() + game.getFirstDice() + game.getSecondDice();

        if(destination!=5 && destination!=9 && destination!= 13 && destination!= 18 && destination!=23 && destination!=27){
        System.out.println(player.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice()
                + ". " + player.getUsername() + " moves from " + player.getCell().getId() + " to " + getId()
                + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination);
        }
        else {
            System.out.println(player.getUsername() + " moves again and goes to " + destination + ", The Goose.");
            int newDestination = destination + game.getFirstDice() + game.getSecondDice();
            game.getCells().get(newDestination).land(player);
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
