package com.example.libraryserviceandroidv2.libraryservice.gameobjects

import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import java.util.ArrayList

object GameList {
    private var INSTANCE: ArrayList<GameModel>? = null

    fun getGameList(): ArrayList<GameModel>{
        if(INSTANCE == null) {
            INSTANCE = ArrayList()
        }

        return INSTANCE!!
    }

    fun setGameList(gameList : ArrayList<GameModel>){
        if(INSTANCE == null) {
            INSTANCE = gameList
        }
    }
}