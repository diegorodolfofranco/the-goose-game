package org.thegoosegame.model.player;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Component
public class Player {
    private String username;
    private int cell;

    //constructor
    public Player(String username, int cell){
        this.username = username;
        this.cell = cell;
    }
}
