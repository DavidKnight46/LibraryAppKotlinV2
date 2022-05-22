package com.example.libraryserviceandroidv2.libraryservice.client.user

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel

interface LibraryServiceUserClient {
    fun getUser(username: String, password: String): UserModel?

    fun addUser(username: String, password: String): UserModel?

    fun removeUser()

    fun changeUsernameAndPassword()
}