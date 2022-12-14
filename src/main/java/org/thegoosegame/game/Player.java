package org.thegoosegame.game;

import java.util.List;
import java.util.Set;

public class Player {
    private String username;
    private int position;
    Game game = new Game();
    private int prevPosition;
    private boolean hasWon;
    private int firstDice;
    private int secondDice;
    Cell c;

    //Constructor
    public Player(String username) {
        this.username = username;
        this.position = 0;
        this.prevPosition = 0;
        this.hasWon = false;
        this.firstDice = 0;
        this.secondDice = 0;
    }

    //Overloading of the constructor
    public Player(String username, int position, int prevPosition, boolean hasWon, int firstDice, int secondDice) {
        this.username = username;
        this.position = position;
        this.prevPosition = prevPosition;
        this.hasWon = hasWon;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
    }

    int i=0;

    //Implements the dice roll
    public void rollDices(Game game) {
        int newPosition;

        //game = new Game(game.getPlayers(), game.getCells(), game.isEnded(), game.getWinner());

        firstDice = (int) (Math.random() * 6) + 1;
        secondDice = (int) (Math.random() * 6) + 1;
        prevPosition = position;

        newPosition = moveForward(firstDice, secondDice);

        if (newPosition < 63) {
            position = newPosition;
            c.setId(position);
            c.setCellOccupied(true);
        }

        System.out.println(game.getId());

        List<Player> occupants = game.getCellOccupants(position);
        List<Cell> cells = game.getCells();

        for (Player player : occupants) {
            if (player.getUsername().equals(username))
                if (c.isCellOccupied())
                    c.prank(prevPosition, position);
            c.move(player, position);
        }
    }

    //Moves the player from to a new position after rolling the dices
    public int moveForward(int firstDice, int secondDice) {
        prevPosition = position;
        int newPosition = position + firstDice + secondDice;
        c.setId(newPosition);
        c.setCellOccupied(true);
        return newPosition;
    }

    //moves the player backwards on the board if the dice roll result is higher than what's needed to win the game
    public int bounce(int position) {
        position = 63 - (position - 63);
        c.setId(position);
        c.setCellOccupied(true);

        return position;
    }

    //returns a string indicating the dice roll's result, the player's old position on the board and the player's new position
    public String showPlayerMovement(int firstDice, int secondDice, int oldPosition, int newPosition) {
        return username + " rolls " + firstDice + ", " + secondDice + ". " + username + " moves from " + oldPosition + " to " + newPosition + ".";
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

    public boolean HasWon() {
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
