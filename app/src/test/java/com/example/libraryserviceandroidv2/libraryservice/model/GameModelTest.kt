package com.example.libraryserviceandroidv2.libraryservice.model

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import junit.framework.Assert.assertEquals
import org.junit.Test

class GameModelTest {
    @Test
    fun foo() {
        var name = GameModel("test", 1).name;

        assertEquals(name, "test");


        //TODO("Not yet implemented")
    }
}