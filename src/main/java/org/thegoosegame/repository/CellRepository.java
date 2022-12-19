package org.thegoosegame.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.thegoosegame.game.Cell;

@Repository
public interface CellRepository extends CrudRepository<Cell, Integer> { }