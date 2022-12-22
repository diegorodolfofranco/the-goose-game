package org.thegoosegame.model.cell;

import lombok.*;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StandardCell implements Cell {
    private Player player;
    private int id;

    //constructor
    public StandardCell(int id) {
        this.id = id;
    }

    //welcomes a player to the cell
    public String land(Player player, int firstDice, int secondDice, String moveResponse){
        if(player!=null){
            moveResponse.concat(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                    + ". " + player.getUsername() + " moves from " + player.getCell() + " to " + id
                    + ". On " + id + " there is " + player.getUsername() + ", who moves to "
                    + player.getCell());

            Player prankedPlayer = player;
            int prankDestinationCell = player.getCell();

            prankedPlayer.setCell(prankDestinationCell);
        }
        else
            moveResponse.concat(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                    + ". " + player.getUsername() + " moves from " + player.getCell() + " to " + id
                    + ".");

        player.setCell(id);
        this.player = player;

        return moveResponse;
    }

    //returns the cell's id
    public int getId() {
        return id;
    }

    //returns the cell's occupant
    public Player getPlayer() {
        return player;
    }

    //sets the cell's occupant
    public void setPlayer(Player player){
        this.player = player;
    }
}
