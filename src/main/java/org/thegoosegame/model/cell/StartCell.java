package org.thegoosegame.model.cell;

import lombok.*;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StartCell implements Cell {
    private Set<Player> players = new LinkedHashSet<>();
    private int id;

    //constructor
    public StartCell(int id) {
        this.id = id;
    }

    //returns the cell's id
    public int getId() {
        return id;
    }

    //sets the cell's occupant
    public void setPlayer(Player player){
        players.add(player);
    }
}
