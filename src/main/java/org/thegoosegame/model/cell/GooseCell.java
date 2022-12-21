package org.thegoosegame.model.cell;

import lombok.*;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GooseCell implements Cell {
    private String gameId;
    private Player player;
    private int id;

    //constructor
    public GooseCell(String gameId, int id) {
        this.gameId = gameId;
        this.id = id;
    }

    //welcomes the player to the cell
    public int land(Game game, Player player, int firstDice, int secondDice) {
        int destination = getId() + firstDice + secondDice;

        if(destination!=5 && destination!=9 && destination!= 13 && destination!= 18 && destination!=23 && destination!=27){
        System.out.println(player.getUsername() + " moves from " + player.getCell() + " to " + getId()
                + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination + ".");
        }
        else {
            System.out.println(player.getUsername() + " moves from " + player.getCell() + " to " + getId()
                    + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination + ", The Goose. ");
            int newDestination = destination + firstDice + secondDice;
            game.getCells().get(newDestination).land(game, player, firstDice, secondDice);
        }

        player.setCell(this.id);

        return destination;
    }

    //returns the cell's id
    public int getId() {
        return id;
    }

    //returns the cell's occupant
    public Player getPlayer() {
        return player;
    }

    //sets the cell's occupant
    public void setPlayer(Player player){
        this.player = player;
    }
}
