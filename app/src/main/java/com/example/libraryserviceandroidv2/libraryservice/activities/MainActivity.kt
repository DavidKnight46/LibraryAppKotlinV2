package com.example.libraryserviceandroidv2.libraryservice.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.libraryappv3.R
import com.example.libraryserviceandroidv2.libraryservice.client.firebase.FirebaseClient
import com.example.libraryserviceandroidv2.libraryservice.client.game.LibraryServiceGameClientImpl
import com.example.libraryserviceandroidv2.libraryservice.client.user.LibraryServiceUserClientImpl
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.User
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var libraryServiceGameClient: LibraryServiceGameClientImpl
    private lateinit var libraryServiceUserClient: LibraryServiceUserClientImpl
    private lateinit var fbClient: FirebaseClient
    private lateinit var textInputEditTextPassword: TextInputEditText
    private lateinit var textInputEditTextUser: TextInputEditText

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)
        loginButton.setText(R.string.altLoginButtonText)

        textInputEditTextPassword = findViewById(R.id.passwordInput)
        textInputEditTextPassword.isVisible = true

        textInputEditTextUser = findViewById(R.id.gameNameInput)
        textInputEditTextUser.isVisible = true

        libraryServiceUserClient = LibraryServiceUserClientImpl()
    }

    fun testClick(view: View) {
        GlobalScope.launch(Dispatchers.IO) {
            var password =
                textInputEditTextPassword.text.toString()
            var username =
                textInputEditTextUser.text.toString()

            User.setUsername(username)

            libraryServiceGameClient = LibraryServiceGameClientImpl()

            fbClient = FirebaseClient(Firebase.auth)

            if (!fbClient.checkUserAlready(username, password)) {
                var detailsGame = libraryServiceGameClient.getDetailsGame(username)
                GameList.setGameList(detailsGame)
            } else {
                //TODO: not successfully
            }

            var intent = Intent(applicationContext, ActivitySelection::class.java)

            startActivity(intent)
        }
    }

    fun onSwitchMode(view: View){
        textInputEditTextPassword.isEnabled = false

        textInputEditTextUser.isEnabled = false
    }

}