package com.example.libraryserviceandroidv2.libraryservice.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.client.user.UserClient

class MainActivity : AppCompatActivity() {

    lateinit var loginButton: Button
    lateinit var userClient: UserClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton =  findViewById(R.id.loginButton)

        userClient = UserClient()
    }

    fun testClick(view: View){
            var intent = Intent(this, viewActivity::class.java)

            startActivity(intent)
    }

}