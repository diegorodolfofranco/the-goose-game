package org.thegoosegame.game;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Player {
    private String username;
    String gameId;
    private Cell cell;

    public Player(String username, String gameId, Cell cell){
        this.username = username;
        this.gameId = gameId;
        this.cell = cell;
    }

    //Implements the dice roll
    public void rollDices(Game game, Player currentPlayer, int firstDice, int secondDice) {
        game.movePlayer(game, currentPlayer, cell);
    }
}
