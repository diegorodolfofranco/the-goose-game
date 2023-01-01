package org.thegoosegame.model.player;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Component
public class Player {
    private String username;
    private int cell;
}