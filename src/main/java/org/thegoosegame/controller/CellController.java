package org.thegoosegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thegoosegame.model.*;
import org.springframework.web.bind.annotation.*;
import org.thegoosegame.game.Cell;
import org.thegoosegame.game.Game;
import org.thegoosegame.game.Player;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.thegoosegame.repository.*;

@RestController
@RequestMapping("/cell")
public class CellController {

    private CellRepository cellRepository;
}
