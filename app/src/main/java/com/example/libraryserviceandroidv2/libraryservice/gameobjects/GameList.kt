package com.example.libraryserviceandroidv2.libraryservice.gameobjects

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

object GameList {
    private var INSTANCE: List<GameModel>? = null

    fun getGameList(): List<GameModel> {
        if (INSTANCE == null) {
            INSTANCE = ArrayList()
        }

        return INSTANCE!!
    }

    fun setGameList(gameList: List<GameModel>) {
        if (INSTANCE == null) {
            INSTANCE = gameList
        }
    }
}