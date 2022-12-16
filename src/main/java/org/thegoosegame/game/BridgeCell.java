package org.thegoosegame.game;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BridgeCell implements Cell {
    String gameId;
    Player player;
    private int id;

    public BridgeCell(String gameId, int id) {
        this.gameId = gameId;
        this.id = id;
    }

    public int land(Player player){
        Game game = new Game();

        if(getPlayer()!=null){
            System.out.println(player.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice()
                    + ". " + player.getUsername() + " moves from " + player.getCell().getId() + " to " + getId()
                    + ". On " + getId() + " there is " + getPlayer().getUsername() + ", who moves to "
                    + player.getCell().getId());

            Player prankedPlayer = getPlayer();
            Cell prankDestinationCell = player.getCell();

            prankedPlayer.setCell(prankDestinationCell);
        }
        else
            System.out.println(player.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice()
                    + ". " + player.getUsername() + " moves from " + player.getCell().getId() + " to 12.");

        player.setCell(this);

        return 12;
    }

    public int getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }
}
