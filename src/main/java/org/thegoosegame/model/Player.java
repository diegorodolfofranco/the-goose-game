package org.thegoosegame.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.thegoosegame.game.*;

@Getter
@Setter
@Entity
@Table(name = "player")
public class Player {
    @Id
    private String username;

    @Column(name = "gameId")
    private String gameId;

    @Column(name = "cell")
    private transient Cell cell;
}
