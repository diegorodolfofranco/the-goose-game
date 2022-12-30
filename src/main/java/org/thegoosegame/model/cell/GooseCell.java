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
public class GooseCell implements Cell {
    private Player player;
    private int id;

    //constructor
    public GooseCell(int id) {
        this.id = id;
    }

    //welcomes the player to the cell
    public String land(Game game, Player player, int dices, String moveResponse) {
        int destination = id + dices;

        if(destination == 13 || destination == 18 || destination == 23){
            moveResponse = moveResponse.concat(player.getUsername() + " moves from " + player.getCell() + " to " + id
                    + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination + ", The Goose. ");
            game.getCells().get(destination).land(game, player, dices, moveResponse);
        }
        else {
            moveResponse = moveResponse.concat(player.getUsername() + " moves from " + (id - dices) + " to " + id
                    + ", The Goose. " + player.getUsername() + " moves again and goes to " + destination + ".");
        }

        player.setCell(destination);
        player.setUsername(player.getUsername());
        game.getCells().get(player.getCell()).setPlayer(null);
        game.getCells().get(destination).setPlayer(player);

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
