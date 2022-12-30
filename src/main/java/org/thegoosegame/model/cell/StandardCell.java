package org.thegoosegame.model.cell;

import lombok.*;
import org.springframework.stereotype.Component;
import org.thegoosegame.model.game.Game;
import org.thegoosegame.model.player.Player;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Component
public class StandardCell implements Cell {
    private int id;
    private Player player;
    //constructor
    public StandardCell(int id) {
        this.id = id;
    }

    //welcomes a player to the cell
    public String land(Game game, Player currentPlayer, int dices, String moveResponse){
        if(player!=null){
            moveResponse = moveResponse.concat(currentPlayer.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice()
                    + ". " + currentPlayer.getUsername() + " moves from " + currentPlayer.getCell() + " to " + id
                    + ". On " + id + " there is " + player.getUsername() + ", who moves to "
                    + currentPlayer.getCell());

            int prankDestinationCell = currentPlayer.getCell();
            player.setCell(prankDestinationCell);
            player.setUsername(player.getUsername());
            game.getCells().get(prankDestinationCell).setPlayer(player);
        }
        else {
            moveResponse = moveResponse.concat(currentPlayer.getUsername() + " rolls " + game.getFirstDice() + ", " + game.getSecondDice()
                    + ". " + currentPlayer.getUsername() + " moves from " + currentPlayer.getCell() + " to " + id
                    + ".");
        }
        currentPlayer.setCell(id);
        currentPlayer.setUsername(currentPlayer.getUsername());
        game.getCells().get(id).setPlayer(currentPlayer);

        return moveResponse;
    }

    //returns the cell's id
    public int getId() {
        return id;
    }

    public Player getPlayer(){
        return player;
    }

    //sets the cell's occupant
    public void setPlayer(Player player){
        this.player = player;
    }
}
