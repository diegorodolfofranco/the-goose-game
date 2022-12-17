package org.thegoosegame.game;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StandardCell implements Cell{
    String gameId;
    Player player;
    private int id;

    //constructor
    public StandardCell(String gameId, int id) {
        this.gameId = gameId;
        this.id = id;
    }

    public int land(Game game, Player player, int firstDice, int secondDice){
        if(getPlayer()!=null){
            System.out.println(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                    + ". " + player.getUsername() + " moves from " + player.getCell().getId() + " to " + getId()
                    + ". On " + getId() + " there is " + getPlayer().getUsername() + ", who moves to "
                    + player.getCell().getId());

            Player prankedPlayer = getPlayer();
            Cell prankDestinationCell = player.getCell();

            prankedPlayer.setCell(prankDestinationCell);
        }
        else
            System.out.println(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                    + ". " + player.getUsername() + " moves from " + player.getCell().getId() + " to " + getId()
                    + ".");

        player.setCell(this);

        return id;
    }

    public int getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }
}
