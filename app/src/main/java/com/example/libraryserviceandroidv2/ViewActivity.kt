package com.example.libraryserviceandroidv2

import android.content.Intent
import android.os.Bundle
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.activities.ActivitySelection
import com.example.libraryserviceandroidv2.libraryservice.adapters.CardViewFilterAdapter
import com.example.libraryserviceandroidv2.libraryservice.adapters.ViewGamesRecyclerAdapter
import com.example.libraryserviceandroidv2.libraryservice.client.game.LibraryServiceGameClientImpl
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.IsPreOrder
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.User
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*
import kotlin.streams.toList

class ViewActivity : AppCompatActivity() {

    private lateinit var libraryServiceGameClientImpl: LibraryServiceGameClientImpl
    private var gameList : List<GameModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        libraryServiceGameClientImpl = LibraryServiceGameClientImpl()

        GlobalScope.launch {
            gameList = libraryServiceGameClientImpl.getDetailsGame(User.getUserName())

            GameList.setGameList(gameList)
        }

        setContentView(R.layout.cardviewgameslayout)

        var preOrderSwitch = findViewById<Switch>(R.id.preOrderSwitch)
        IsPreOrder.setIsPreOrder(Integer(1))

        preOrderSwitch.setOnClickListener {
            if(preOrderSwitch.isChecked){
                IsPreOrder.setIsPreOrder(Integer(0))
                foo(true)
            }

            lifecycleScope.launch {
                foo(false)
            }
        }

        lifecycleScope.launch {
            foo(false)
        }

    }

    private fun foo(isChecked: Boolean) {
        var cardviewviewlayout = findViewById<RecyclerView>(R.id.cardviewviewlayout)

        val linearLayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        var findViewById = findViewById<Spinner>(R.id.viewFilterTypes)
        var isPreOrder = findViewById<Switch>(R.id.preOrderSwitch)

        var selectedItem = findViewById<Spinner>(R.id.viewFilterResults)?.selectedItem

        var toList: List<GameModel>

        if(isChecked) {
            toList = GameList.getGameList().stream()
                .filter { e -> e.platform.contentEquals(selectedItem.toString()) }.toList()

            println("smurf")
        } else {
            toList = GameList.getGameList()
        }


        findViewById.onItemSelectedListener = CardViewFilterAdapter(
            findViewById(R.id.viewFilterResults),
            applicationContext,
            toList,
            cardviewviewlayout,
            linearLayoutManager,
            isPreOrder.isChecked
        )

        cardviewviewlayout.layoutManager = linearLayoutManager

        cardviewviewlayout.adapter = ViewGamesRecyclerAdapter(gameList)
    }
}