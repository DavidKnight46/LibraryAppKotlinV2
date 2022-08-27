package com.example.libraryserviceandroidv2.libraryservice.client.user

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel
import retrofit2.Response

class LibraryServiceUserClientImpl : LibraryServiceUserClient {
    override fun getUser(userModel: UserModel): Boolean? {
        return callUserGetAPIEndpoint(userModel).body()
    }

    override fun addUser(userModel: UserModel): Boolean? {
        return callUserAPIEndpoint(userModel)?.body()
    }

    override fun removeUser() {}

    override fun changeUsernameAndPassword() {}

    private fun callUserAPIEndpoint(userModel: UserModel): Response<Boolean> {
        return com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyUserRxClient
            .getRxClient()
            .create(MyUserRxClient::class.java)
            .getAnUser(userModel)
            .execute()
    }

    private fun callUserGetAPIEndpoint(userModel: UserModel): Response<Boolean> {
        return com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyUserRxClient.getRxClient()
            .create(MyUserRxClient::class.java).getAnUser(userModel).execute();
    }
}