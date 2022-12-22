package org.thegoosegame.model.game;

import lombok.*;
import org.springframework.stereotype.Component;
import org.thegoosegame.model.player.Player;
import org.thegoosegame.model.cell.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Component
public class Game {
    private Set<Player> players = new LinkedHashSet<>();
    private List<Cell> cells = new ArrayList<>(64);
    private boolean isEnded;
    private String winner;
    private int firstDice;
    private int secondDice;

    //constructor
    public Game(Set<Player> players, List<Cell> cells, boolean isEnded, String winner) {
        this.players = players;
        this.cells = cells;
        this.isEnded = isEnded;
        this.winner = winner;
        this.firstDice = 0;
        this.secondDice = 0;
    }
}
