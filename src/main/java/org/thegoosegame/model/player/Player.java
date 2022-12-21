package org.thegoosegame.model.player;

import lombok.*;
import org.thegoosegame.model.game.Game;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Player {
    private String username;
    private String gameId;
    private int cell;

    //constructor
    public Player(String username, String gameId, int cell){
        this.username = username;
        this.gameId = gameId;
        this.cell = cell;
    }

    //implements the dice roll
    public void rollDices(Game game, Player currentPlayer) {
        game.movePlayer(game, currentPlayer, cell);
    }
}
