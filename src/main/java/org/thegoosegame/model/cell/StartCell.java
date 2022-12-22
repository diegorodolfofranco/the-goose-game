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

    //welcomes a player to the cell
    public String land(Game game, Player player, int firstDice, int secondDice, String moveResponse){
        player.setCell(0);
        players.add(player);

        player.setCell(id);
        game.getCells().get(0).setPlayer(null);
        game.getCells().get(id).setPlayer(player);

        player.setUsername(player.getUsername());
        player.setCell(id);
        player.setUsername(player.getUsername());

        return moveResponse;
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
