package org.thegoosegame.model.cell;

import lombok.*;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StandardCell implements Cell {
    private Player player;
    private int id;

    //constructor
    public StandardCell(int id) {
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
