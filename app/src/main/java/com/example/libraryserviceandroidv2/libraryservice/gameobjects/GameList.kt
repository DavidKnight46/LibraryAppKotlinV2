package com.example.libraryserviceandroidv2.libraryservice.gameobjects

import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import java.util.ArrayList

object GameList {
    var list: List<GameEntity> = ArrayList()

    fun setGameList(list: List<GameEntity>){
        this.list = list
    }

    fun getGameList(): List<GameEntity>{
        return list
    }
}