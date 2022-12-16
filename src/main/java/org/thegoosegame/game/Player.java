package org.thegoosegame.game;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Player {
    private String username;
    Game game = new Game();
    private Cell cell;

    public Player(String username, Cell cell){
        this.username = username;
        this.cell = cell;
    }

    //Implements the dice roll
    public void rollDices(Player currentPlayer, int firstDice, int secondDice) {
        Game game = new Game();

        game.movePlayer(currentPlayer, cell);
    }
}
