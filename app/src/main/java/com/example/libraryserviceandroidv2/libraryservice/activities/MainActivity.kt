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
import com.example.libraryserviceandroidv2.libraryservice.client.user.UserClient
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.User
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.stream.Collectors

class MainActivity : AppCompatActivity() {

    lateinit var loginButton: Button
    lateinit var userClient: UserClient
    lateinit var libraryServiceGameClient: LibraryServiceGameClientImpl

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)
        loginButton.setText(R.string.altLoginButtonText)

        findViewById<TextInputEditText>(R.id.passwordInput).isVisible = true
        findViewById<TextInputEditText>(R.id.gameNameInput).isVisible = true

        userClient = UserClient()
    }

    fun testClick(view: View) {
        GlobalScope.launch(Dispatchers.IO) {
            var password = findViewById<TextInputEditText>(R.id.passwordInput).text
            var username = findViewById<TextInputEditText>(R.id.gameNameInput).text

            libraryServiceGameClient = LibraryServiceGameClientImpl()

            var anUser =
                libraryServiceGameClient.getAnUser(username.toString(), password.toString())

            User.setID(anUser?.id.toString())

            var detailsGame = libraryServiceGameClient.getDetailsGame(User.getId().toInt())

            var collect =
                detailsGame.stream().map { e -> createGameModel(e) }.collect(Collectors.toList())

            GameList.setGameList(collect)

            var intent = Intent(applicationContext, viewActivity::class.java)

            startActivity(intent)
        }
    }

    fun createGameModel(gameModel: GameModel): GameEntity {
        var isPreOrdered : Int

        if(gameModel.preOrdered){
            isPreOrdered = 0
        }else{
            isPreOrdered = 1
        }

        return GameEntity(
            gameModel.id,
            gameModel.gameName,
            gameModel.gameGenre,
            gameModel.platform,
            gameModel.gameRating,
            gameModel.releaseDate,
            gameModel.imageUrl,
            isPreOrdered
        )
    }

}