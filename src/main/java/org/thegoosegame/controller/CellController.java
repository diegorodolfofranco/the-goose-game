package org.thegoosegame.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thegoosegame.game.*;

import java.util.*;

@RestController
public class CellController {
    Game game = new Game();
    private int id;
    private boolean isOccupied;

    @GetMapping("/cell")
    public Cell cell(@RequestParam(value = "id") int id){
        if(id<0 || id>63){
            return new StandardCell(-1);}
        else if(id==6)
            return new BridgeCell(id);
        else if((id==5 || id==9 || id==13 || id==18 || id==23 || id==27))
            return new GooseCell(id);
            else
                return new StandardCell(id);
    }
}
