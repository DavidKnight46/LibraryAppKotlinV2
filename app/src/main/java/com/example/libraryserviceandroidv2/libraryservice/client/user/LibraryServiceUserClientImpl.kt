package com.example.libraryserviceandroidv2.libraryservice.client.user

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel
import retrofit2.Response

class LibraryServiceUserClientImpl : LibraryServiceUserClient {
    override fun getUser(userModel: UserModel): Boolean? {
        return callGetUserEndpoint(userModel)?.body()
    }

    override fun createNewUser(userModel: UserModel): Boolean? {
        return callCreateUserEndpoint(userModel)?.body()
    }

    override fun removeUser() {}

    override fun changeUsernameAndPassword() {}

    private fun callCreateUserEndpoint(userModel: UserModel): Response<Boolean> {
        return com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyUserRxClient
            .getRxClient()
            .create(MyUserRxClient::class.java)
            .createAnUser(userModel)
            .execute()
    }

    private fun callGetUserEndpoint(userModel: UserModel): Response<Boolean> {
        return com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyUserRxClient
            .getRxClient()
            .create(MyUserRxClient::class.java)
            .getAnUser(userModel)
            .execute();
    }
}