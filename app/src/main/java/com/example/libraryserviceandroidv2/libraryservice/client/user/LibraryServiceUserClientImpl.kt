package com.example.libraryserviceandroidv2.libraryservice.client.user

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel
import retrofit2.Response

class LibraryServiceUserClientImpl : LibraryServiceUserClient {
    override fun getUser(username: String, password: String): UserModel? {
        return callUserGetAPIEndpoint(username, password).body()
    }

    override fun addUser(username: String, password: String): UserModel? {
        return callUserAPIEndpoint(username, password)?.body()
    }

    override fun removeUser() {}

    override fun changeUsernameAndPassword() {}

    private fun callUserAPIEndpoint(username: String, password: String): Response<UserModel> {
        return com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyUserRxClient
            .getRxClient()
            .create(MyUserRxClient::class.java)
            .getAnUser(username, password)
            .execute()
    }

    private fun callUserGetAPIEndpoint(username: String, password: String): Response<UserModel> {
        return com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyUserRxClient.getRxClient()
            .create(MyUserRxClient::class.java).getAnUser(username, password).execute();
    }
}