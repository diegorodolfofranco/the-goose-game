package org.thegoosegame.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.thegoosegame.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, String> { }