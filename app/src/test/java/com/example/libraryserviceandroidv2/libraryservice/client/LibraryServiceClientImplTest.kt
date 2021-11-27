package com.example.libraryserviceandroidv2.libraryservice.client

import com.example.libraryserviceandroidv2.libraryservice.client.user.UserClient
import org.junit.Assert.*
import org.junit.Test

class LibraryServiceClientImplTest{

    val userName: String = "test"
    val passWord: String = "password123"


    lateinit var underTest: UserClient

    @Test
    fun test(){
        underTest = UserClient()

        var checkUser = underTest.checkUser(userName, passWord)

        assertTrue(checkUser)
    }
}