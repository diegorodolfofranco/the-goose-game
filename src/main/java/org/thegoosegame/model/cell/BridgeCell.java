package org.thegoosegame.model.cell;

import lombok.*;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BridgeCell implements Cell {
    private Player player;
    private int id;

    //constructor
    public BridgeCell(int id) {
        this.id = id;
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
