package org.thegoosegame.game;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Player {
    private String gameId = getGameId();
    private String username;
    private int position;
    private int prevPosition;
    private boolean hasWon;
    private int firstDice;
    private int secondDice;

    //Constructor
    public Player(String gameId, String username) {
        this.gameId = gameId;
        this.username = username;
        this.position = 0;
        this.prevPosition = 0;
        this.hasWon = false;
        this.firstDice = 0;
        this.secondDice = 0;
    }

    public Player(String gameId, String username,int position,int prevPosition,boolean hasWon,int firstDice,int secondDice) {
        this.gameId = gameId;
        this.username = username;
        this.position = position;
        this.prevPosition = prevPosition;
        this.hasWon = hasWon;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
    }

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
            //c.setId(position);
            //c.setCellOccupied(true);
        }

        System.out.println(game.getId());

        Player occupant = game.getCellOccupant(position);
        List<Cell> cells = game.getCells();

        for (Player player : game.getPlayers()) {
            /*if (player.getUsername().equals(username))
                if (cells.get(c.getId()).isCellOccupied())
                    cells.get(c.getId()).prank(prevPosition, position);
            cells.get(c.getId()).move(player, position);*/
        }
    }

    //Moves the player from to a new position after rolling the dices
    public int moveForward(int firstDice, int secondDice) {
        prevPosition = position;
        int newPosition = position + firstDice + secondDice;
        //c.setId(newPosition);
        //c.setCellOccupied(true);
        return newPosition;
    }

    //moves the player backwards on the board if the dice roll result is higher than what's needed to win the game
    public int bounce(int position) {
        position = 63 - (position - 63);
        //c.setId(position);
        //c.setCellOccupied(true);

        return position;
    }

    //returns a string indicating the dice roll's result, the player's old position on the board and the player's new position
    public String showPlayerMovement(int firstDice, int secondDice, int oldPosition, int newPosition) {
        return username + " rolls " + firstDice + ", " + secondDice + ". " + username + " moves from " + oldPosition + " to " + newPosition + ".";
    }
}
