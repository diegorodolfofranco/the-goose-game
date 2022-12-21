package org.thegoosegame.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private static GameService gameInstance;

    private GameService(){}

    public static GameService getGameInstance(){
        if(gameInstance==null){
            gameInstance = new GameService();
        }
        return gameInstance;
    }
}
