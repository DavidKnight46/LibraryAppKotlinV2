package com.example.libraryserviceandroidv2.libraryservice.client.user

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import java.net.URI
import java.net.URISyntaxException
import java.util.logging.Level
import java.util.logging.Logger

class UserClient {

    var logger = Logger.getLogger("UserClient")

    fun checkUser(user: String, password: String): Boolean{
        //callEndpoint(user, password)
        return true
    }

    private fun callEndpoint(user: String, password: String){
        try {
            var uri = String.format(
                "http://localhost:8080/libraryservice/user/checkUser?userName=%s&password=%s",
                user, password
            )

            var execute = HttpClients.createDefault().execute(HttpGet(URI.create(uri)))

            do {
                var content = execute.entity.content

            }while(content.available() != 0)

        } catch (e: URISyntaxException){
            logger.log(Level.SEVERE, "Unable to call endpoint")
        }

    }
}