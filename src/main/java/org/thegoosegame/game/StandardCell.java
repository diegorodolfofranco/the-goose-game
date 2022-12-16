package org.thegoosegame.game;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class StandardCell implements Cell{
    Game game = new Game();
    String gameId = getGameId();
    Player player;
    private int id;

    //constructor
    public StandardCell(int id) {
        this.gameId = game.getId();
        this.player = game.getCellOccupant(id);
        this.id = id;
    }

    public void move(Player player, int position){

    }

    //if player A moves to a cell where there's already at least another player B, player B moves to player A's old position.
    public void prank(int prevPosition, int position){
        Player occupant = game.getCellOccupant(position);
        occupant.setPosition(player.getPrevPosition());
    }
}
