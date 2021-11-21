package com.example.libraryserviceandroidv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.libraryserviceandroidv2.libraryservice.client.user.UserClient

class MainActivity : AppCompatActivity() {

    lateinit var userNameTextView: EditText
    lateinit var passwordTextView: EditText
    lateinit var loginButton: Button

    lateinit var userClient: UserClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameTextView = findViewById(R.id.userName)
        passwordTextView = findViewById(R.id.passwordTextField)

        loginButton =  findViewById(R.id.loginButton)

        loginButton.setOnClickListener { loginUser() }

        userClient = UserClient()

    }

    private fun loginUser(){
        var userName = userNameTextView.text.toString()
        var password = passwordTextView.text.toString()

        userClient.checkUser(userName, password)

        System.out.println("smurf")
    }


}