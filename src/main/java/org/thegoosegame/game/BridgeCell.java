package org.thegoosegame.game;

public class BridgeCell implements Cell {
    Game game = new Game();
    Player player;
    private int id;

    public BridgeCell(int id) {
        this.player = game.getCellOccupant(id);
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

    public void prank(int prevPosition, int position) {
        Player occupant = game.getCellOccupant(position);
        occupant.setPosition(player.getPrevPosition());
    }
}
