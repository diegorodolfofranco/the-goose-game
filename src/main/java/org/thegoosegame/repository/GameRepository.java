package org.thegoosegame.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.thegoosegame.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, String> { }
