package com.example.libraryserviceandroidv2.libraryservice.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.client.user.UserClient
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var loginButton: Button
    lateinit var userClient: UserClient

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton =  findViewById(R.id.loginButton)
        loginButton.setText(R.string.altLoginButtonText)

        findViewById<TextInputEditText>(R.id.passwordInput).isVisible = false
        findViewById<TextInputEditText>(R.id.gameNameInput).isVisible = false

        userClient = UserClient()
    }

    fun testClick(view: View){
            var intent = Intent(this, viewActivity::class.java)

            startActivity(intent)
    }

}