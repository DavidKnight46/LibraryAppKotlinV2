package com.example.libraryserviceandroidv2

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.adapters.CardViewFilterAdapter
import com.example.libraryserviceandroidv2.libraryservice.adapters.ViewGamesRecyclerAdapter
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import kotlinx.coroutines.launch

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.cardviewgameslayout)

        lifecycleScope.launch {
            var gameList = MyDataBaseBuilder.getInstance(applicationContext).gameDao().getAll()

            GameList.setGameList(gameList)

            var f = findViewById<RecyclerView>(R.id.cardviewviewlayout)

            val linearLayoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            var findViewById = findViewById<Spinner>(R.id.viewFilterTypes)
            findViewById.onItemSelectedListener = CardViewFilterAdapter(
                findViewById(R.id.viewFilterResults),
                applicationContext,
                GameList.getGameList(),
                f,
                linearLayoutManager
            )

            f.layoutManager = linearLayoutManager
            f.adapter = ViewGamesRecyclerAdapter(gameList)
        }

    }

}