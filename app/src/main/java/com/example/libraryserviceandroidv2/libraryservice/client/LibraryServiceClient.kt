package com.example.libraryserviceandroidv2.libraryservice.client

import com.example.libraryserviceandroidv2.libraryservice.model.GameModel

class LibraryServiceClient {

    fun foo():String{
        var gameModel = GameModel("test", 1);

        var name = gameModel.name;
        return "";
    }
}