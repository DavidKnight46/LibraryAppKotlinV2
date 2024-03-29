package com.example.libraryserviceandroidv2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.FragmentContainerView
import com.example.libraryserviceandroidv2.libraryservice.adapters.EditGamesAdapter
import com.example.libraryserviceandroidv2.libraryservice.client.game.LibraryServiceGameClientImpl
import com.example.libraryserviceandroidv2.libraryservice.client.user.LibraryServiceUserClientImpl
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.IsAdded
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.User
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {

    private lateinit var gameList : List<GameModel>

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        IsAdded.setIsAdded(false)

        setContentView(R.layout.layouteditactivity)

        var findViewById = findViewById<Spinner>(R.id.gamesToEdit)

        var libraryServiceUserClient = LibraryServiceGameClientImpl()

        GlobalScope.launch(Dispatchers.IO){
            gameList = libraryServiceUserClient.getDetailsGame(User.getUserName())

            async {
                findViewById.adapter =
                    ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, gameList)

                findViewById.onItemSelectedListener = EditGamesAdapter(gameList,
                    findViewById(R.id.fragmentViewContainer))
            }
        }
    }
}