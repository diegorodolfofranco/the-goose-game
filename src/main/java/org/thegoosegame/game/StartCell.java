package org.thegoosegame.game;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StartCell implements Cell {
    private String gameId;
    private Set<Player> players = new LinkedHashSet<>();
    private int id;

    public StartCell(String gameId, int id) {
        this.gameId = gameId;
        this.id = id;
    }

    public int land(Game game, Player player, int firstDice, int secondDice){
        player.setCell(this);
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setPlayer(Player player){
        players.add(player);
    }
}
