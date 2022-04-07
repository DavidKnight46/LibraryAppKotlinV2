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
    fun foo() {
        //libraryServiceGameClient = LibraryServiceGameClientImpl()

        libraryServiceGameClient.getDetailsGame("1")


    }
}