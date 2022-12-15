package org.thegoosegame.game;

import java.util.Set;

public class StartCell implements Cell {
    Game game = new Game();
    Set<Player> players;
    private int id;

    public StartCell(int id) {
        this.players = game.getCellOccupants(id);
        this.id = id;
    }

    public void move(Player player, int position) {
        /*
        Set<Player> players = new LinkedHashSet<>();
        players = players[id].getGame().getCellOccupants(6);
        */

        player.setPrevPosition(player.getPosition());
        player.setPosition(12);
    }

    public void prank(int prevPosition, int position){

    }
}
