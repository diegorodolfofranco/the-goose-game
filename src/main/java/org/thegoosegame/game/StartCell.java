package org.thegoosegame.game;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StartCell implements Cell {
    String gameId;
    Set<Player> players;
    private int id;

    public StartCell(String gameId, int id) {
        this.gameId = gameId;
        this.id = id;
    }

    public int land(Player player){
        player.setCell(this);
        return 0;
    }

    public int getId() {
        return id;
    }
}
