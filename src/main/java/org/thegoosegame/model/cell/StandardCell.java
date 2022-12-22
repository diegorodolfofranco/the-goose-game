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
    public String land(Game game, Player player, int firstDice, int secondDice, String moveResponse){
        if(this.player!=null){
            moveResponse = moveResponse.concat(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                    + ". " + player.getUsername() + " moves from " + player.getCell() + " to " + id
                    + ". On " + id + " there is " + this.player.getUsername() + ", who moves to "
                    + player.getCell());

            Player prankedPlayer = this.player;
            int prankDestinationCell = player.getCell();

            prankedPlayer.setCell(prankDestinationCell);
        }
        else
            moveResponse = moveResponse.concat(player.getUsername() + " rolls " + firstDice + ", " + secondDice
                    + ". " + player.getUsername() + " moves from " + player.getCell() + " to " + id
                    + ".");

        player.setCell(id);

        player.setCell(id);
        player.setUsername(player.getUsername());
        game.getCells().get(player.getCell()).setPlayer(null);
        game.getCells().get(id).setPlayer(player);

        return moveResponse;
    }

    //returns the cell's id
    public int getId() {
        return id;
    }

    //sets the cell's occupant
    public void setPlayer(Player player){
        this.player = player;
    }
}
