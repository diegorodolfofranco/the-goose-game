/*package org.thegoosegame.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    @DisplayName("Should start a new turn if the username of the player does not already exist")
    void newTurnWhenUsernameDoesNotAlreadyExist () {

    }

    @Test
    void createPlayerTest() {
    }

    @Test
    void listPlayersTest() {
    }

    @Test
    void playerCheckTest() {
    }

    @Test
    void initializeBoardTest() {
    }

    @Test
    void addPlayerTest() {
    }

    @Test
    @DisplayName("Should return an array with one player when there is one player on the cell")
    void getCellOccupantsWhenThereIsOnePlayerOnTheCellThenReturnArrayWithOnePlayer() {
        Game game = new Game(new Player[0], new Cell[64], false, "");
        Player player = new Player("player1");
        player.setPosition(5);
        game.addPlayer(player);

        Player[] players = game.getCellOccupants(5);

        assertEquals(1, players.length);
    }

    @Test
    @DisplayName("Should return an empty array when there is no player on the cell")
    void getCellOccupantsWhenThereIsNoPlayerOnTheCellThenReturnEmptyArray() {
        Game game = new Game(new Player[0], new Cell[64], false, "");
        game.initializeBoard();

        Player[] players = game.getCellOccupants(0);

        assertEquals(0, players.length);
    }

    @Test
    @DisplayName("Should return an array with two players when there are two players on the cell")
    void getCellOccupantsWhenThereAreTwoPlayersOnTheCellThenReturnArrayWithTwoPlayers() {
        Game game = new Game(new Player[0], new Cell[64], false, "");
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        player1.setPosition(5);
        player2.setPosition(5);
        game.addPlayer(player1);
        game.addPlayer(player2);

        Player[] players = game.getCellOccupants(5);

        assertEquals(2, players.length);
    }

    @Test
    void getPlayersTest() {
    }

    @Test
    void setPlayersTest() {
    }

    @Test
    void getCellsTest() {
    }

    @Test
    void setCellsTest() {
    }

    @Test
    void isEndedTest() {
    }

    @Test
    void setEndedTest() {
    }

    @Test
    void getWinnerTest() {
    }

    @Test
    void setWinnerTest() {
    }
}*/