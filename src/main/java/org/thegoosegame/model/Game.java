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
@Table(name = "game")
public class Game{
    @Id
    private String id;

    @Column(name = "players")
    private transient Set<Player> players;

    @Column(name = "cells")
    private transient List<Cell> cells;

    @Column(name = "isEnded")
    private boolean isEnded;

    @Column(name = "winner")
    private String winner;

    @Column(name = "firstDice")
    private int firstDice;

    @Column(name = "secondDice")
    private boolean secondDice;
}
