package com.example.libraryserviceandroidv2.libraryservice.gameobjects

import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import java.util.ArrayList

object GameList {
    private var INSTANCE: ArrayList<GameEntity>? = null

    fun getGameList(): ArrayList<GameEntity>{
        if(INSTANCE == null) {
            INSTANCE = ArrayList()
        }

        return INSTANCE!!
    }
}