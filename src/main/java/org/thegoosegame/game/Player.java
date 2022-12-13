package org.thegoosegame.game;

public class Player {
    private Game game;
    private String username;
    private int position;

    private int prevPosition;
    private boolean hasWon;
    private int firstDice;
    private int secondDice;

    public Player(String username) {
        this.username = username;
        this.position = 0;
        this.prevPosition = 0;
        this.hasWon = false;
        this.firstDice = 0;
        this.secondDice = 0;
    }

    public Player(String username, int position, int prevPosition, boolean hasWon, int firstDice, int secondDice) {
        this.username = username;
        this.position = position;
        this.prevPosition = prevPosition;
        this.hasWon = hasWon;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
    }

    public void rollDices(){
        int newPosition;

        firstDice = (int)(Math.random() * 6) + 1;
        secondDice = (int)(Math.random() * 6) + 1;
        prevPosition = position;

        newPosition = moveForward(firstDice, secondDice);

        if(newPosition>63)
            newPosition = bounce(newPosition);

        setPosition(newPosition);

        Player[] players = getGame().getCellOccupants(position);
        Cell[] cells = getGame().getCells();

        for (Player player : players) {
            if(player.getUsername() == getUsername())
                if(cells[position].isCellOccupied() == true)
                    cells[position].prank(prevPosition, position);
                cells[position].move();
        }

        getGame().newTurn();
    }

    public int moveForward(int firstDice, int secondDice){
        prevPosition = position;
        return position + firstDice + secondDice;
    }

    public int bounce(int position){
        position = 63 - (position - 63);

        return position;
    }

    public String showPlayerMovement(int firstDice, int secondDice, int oldPosition, int newPosition){
        return username + " rolls " + firstDice + ", " + secondDice + ". " + username + " moves from " + oldPosition + " to " + newPosition + ".";
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPrevPosition() {
        return prevPosition;
    }

    public void setPrevPosition(int prevPosition) {
        this.prevPosition = prevPosition;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public int getFirstDice() {
        return firstDice;
    }

    public void setFirstDice(int firstDice) {
        this.firstDice = firstDice;
    }

    public int getSecondDice() {
        return secondDice;
    }

    public void setSecondDice(int secondDice) {
        this.secondDice = secondDice;
    }
}
