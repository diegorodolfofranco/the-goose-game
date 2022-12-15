package org.thegoosegame.game;

import java.util.List;
import java.util.Objects;

public class GooseCell implements Cell {
    Game game = new Game();
    Player player = new Player();
    private int id;

    public GooseCell(int id) {
        this.player = game.getCellOccupant(id);
        this.id = id;
    }

    public void move(Player player, int position) {
        if (position == 5 || position == 9 || position == 14 || position == 18 || position == 23 || position == 27)
            player.setPosition(position + game.getFirstDice() + game.getSecondDice());
    }

    public void prank(int prevPosition, int position) {
        Player occupant = game.getCellOccupant(position);
        occupant.setPosition(player.getPrevPosition());
    }
}
