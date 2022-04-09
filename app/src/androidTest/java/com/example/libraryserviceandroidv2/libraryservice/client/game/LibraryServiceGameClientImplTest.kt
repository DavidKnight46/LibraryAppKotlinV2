package com.example.libraryserviceandroidv2.libraryservice.client.game

import org.junit.Before
import org.junit.Test

class LibraryServiceGameClientImplTest {

    lateinit var libraryServiceGameClient: LibraryServiceGameClientImpl

    @Before
    fun init() {
        libraryServiceGameClient = LibraryServiceGameClientImpl()
    }

    @Test
    fun getGamesFromApi() {
        var detailsGame = libraryServiceGameClient.getDetailsGame(1)
    }

    @Test
    fun getUsersFromAPI() {
        var anUser = libraryServiceGameClient.getAnUser("TestUser1", "Password1")
    }
}