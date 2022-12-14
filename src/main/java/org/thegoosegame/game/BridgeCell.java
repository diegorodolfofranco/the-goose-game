package org.thegoosegame.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BridgeCell implements Cell {
    private Game game = new Game();
    private int id;
    private boolean isOccupied;

    public BridgeCell(int id, boolean isOccupied) {
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public void move(Player player, int position) {
        Set<Player> players = new HashSet<Player>();
        //players = players[id].getGame().getCellOccupants(6);

        player.setPrevPosition(player.getPosition());
        player.setPosition(12);
    }

    public void prank(int prevPosition, int position) {
        List<Player> occupants = game.getCellOccupants(position);

        for (Player player : occupants)
            player.setPosition(prevPosition);
    }

    public boolean isCellOccupied() {
        return isOccupied;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCellOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
