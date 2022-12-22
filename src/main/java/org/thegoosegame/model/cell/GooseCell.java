package org.thegoosegame.model.cell;

import lombok.*;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GooseCell implements Cell {
    private Player player;
    private int id;

    //constructor
    public GooseCell(int id) {
        this.id = id;
    }

    //welcomes the player to the cell
    public int land(Player player, int firstDice, int secondDice) {
        int destination = id + firstDice + secondDice;

        if(destination!=5 && destination!=9 && destination!= 13 && destination!= 18 && destination!=23 && destination!=27){
            System.out.println(player.getUsername() + " moves from " + player.getCell() + " to " + id
                    + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination + ".");
        }
        else {
            System.out.println(player.getUsername() + " moves from " + player.getCell() + " to " + id
                    + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination + ", The Goose. ");
            int newDestination = destination + firstDice + secondDice;
            land(player, firstDice, secondDice);
        }

        player.setCell(id);

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
