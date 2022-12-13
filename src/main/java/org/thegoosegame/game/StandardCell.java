package org.thegoosegame.game;

public class StandardCell implements Cell{
    private Game game;
    private int id;
    private boolean isOccupied;

    public StandardCell(int id, boolean isOccupied) {
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public void move(){

    }

    public void prank(int prevPosition, int position){
        Player[] occupants = getGame().getCellOccupants(position);

        for (Player player : occupants)
            player.setPosition(prevPosition);
    }

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

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
