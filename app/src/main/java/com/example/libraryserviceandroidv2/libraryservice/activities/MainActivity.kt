package com.example.libraryserviceandroidv2.libraryservice.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.client.game.LibraryServiceGameClientImpl
import com.example.libraryserviceandroidv2.libraryservice.client.user.LibraryServiceUserClientImpl
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.model.UserModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var loginButton: Button
    lateinit var libraryServiceGameClient: LibraryServiceGameClientImpl
    lateinit var libraryServiceUserClient: LibraryServiceUserClientImpl

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)
        loginButton.setText(R.string.altLoginButtonText)

        findViewById<TextInputEditText>(R.id.passwordInput).isVisible = true
        findViewById<TextInputEditText>(R.id.gameNameInput).isVisible = true

        libraryServiceUserClient = LibraryServiceUserClientImpl()
    }

    fun testClick(view: View) {
        GlobalScope.launch(Dispatchers.IO) {
            var password = findViewById<TextInputEditText>(R.id.passwordInput).text.toString()
            var username = findViewById<TextInputEditText>(R.id.gameNameInput).text.toString()

            libraryServiceGameClient = LibraryServiceGameClientImpl()

            var anUser =
                libraryServiceUserClient.getUser(UserModel(username, password))

            if(anUser!!) {
                var detailsGame = libraryServiceGameClient.getDetailsGame(username)

                GameList.setGameList(detailsGame)

                var intent = Intent(applicationContext, viewActivity::class.java)

                startActivity(intent)
            }
        }
    }

}