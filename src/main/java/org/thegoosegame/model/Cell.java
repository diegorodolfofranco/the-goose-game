package org.thegoosegame.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.thegoosegame.game.*;
import org.thegoosegame.game.Player;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cell")
public class Cell {
    @Column(name = "gameId")
    private String gameId;
    @Column(name = "player")
    private transient Player player;
    @Id
    private int id;
}