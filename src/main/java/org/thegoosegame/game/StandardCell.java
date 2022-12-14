package org.thegoosegame.game;

import java.util.List;

public class StandardCell implements Cell{
    private Game game = new Game();
    private int id;
    private boolean isOccupied;

    //constructor
    public StandardCell(int id, boolean isOccupied) {
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public void move(Player player, int position){

    }

    //if player A moves to a cell where there's already at least another player B, player B moves to player A's old position.
    public void prank(int prevPosition, int position){
        List<Player> occupants = game.getCellOccupants(position);

        for (Player player : occupants)
            player.setPosition(prevPosition);
    }

    //returns true if there's at least a player on the cell
    public boolean isCellOccupied(){
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
