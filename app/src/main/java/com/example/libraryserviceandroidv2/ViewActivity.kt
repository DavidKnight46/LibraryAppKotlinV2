package com.example.libraryserviceandroidv2

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.adapters.CardViewFilterAdapter
import com.example.libraryserviceandroidv2.libraryservice.adapters.ViewGamesRecyclerAdapter
import com.example.libraryserviceandroidv2.libraryservice.client.game.LibraryServiceGameClientImpl
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.User
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewActivity : AppCompatActivity() {

    private lateinit var libraryServiceGameClientImpl: LibraryServiceGameClientImpl
    private var gameList : List<GameModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        libraryServiceGameClientImpl = LibraryServiceGameClientImpl()

        var viewFilterSpinner = findViewById<Spinner>(R.id.viewFilterTypes)
        var viewFilterTypes = findViewById<Spinner>(R.id.viewFilterResults)

        viewFilterSpinner?.setSelection(1)
        viewFilterTypes?.setSelection(1)

        GlobalScope.launch {
            GameList.setGameList(libraryServiceGameClientImpl.getDetailsGame(User.getUserName()))
        }

        setContentView(R.layout.cardviewgameslayout)

        lifecycleScope.launch {
            setResultSpinners()
        }

    }

    private fun setResultSpinners() {
        var cardviewviewlayout = findViewById<RecyclerView>(R.id.cardviewviewlayout)

        val linearLayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        var findViewById = findViewById<Spinner>(R.id.viewFilterTypes)

        var platFormArray = resources.getStringArray(R.array.platforms)
        var genreArray = resources.getStringArray(R.array.genre)

        findViewById.onItemSelectedListener = CardViewFilterAdapter(
            platFormArray,
            genreArray,
            findViewById(R.id.viewFilterResults),
            applicationContext,
            GameList.getGameList(),
            cardviewviewlayout,
            linearLayoutManager,
            false
        )

        cardviewviewlayout.layoutManager = linearLayoutManager

        cardviewviewlayout.adapter = ViewGamesRecyclerAdapter(gameList)
    }
}