package com.example.libraryserviceandroidv2.libraryservice.client.user

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel

interface LibraryServiceUserClient {
    fun getUser(userModel: UserModel): Boolean?

    fun createNewUser(userModel: UserModel): Boolean?

    fun removeUser()

    fun changeUsernameAndPassword()
}