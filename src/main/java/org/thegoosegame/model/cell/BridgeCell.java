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
public class BridgeCell implements Cell {
    private Player player;
    private int id;

    //constructor
    public BridgeCell(int id) {
        this.id = id;
    }

    //welcomes a player to the cell
    public String land(Game game, Player currentPlayer, int dices, String moveResponse){
        moveResponse = moveResponse.concat(currentPlayer.getUsername() + " moves from " + currentPlayer.getCell() + " to 12.");

        currentPlayer.setCell(12);
        game.getCells().get(currentPlayer.getCell()).setPlayer(currentPlayer);
        game.getCells().get(6).setPlayer(null);

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
