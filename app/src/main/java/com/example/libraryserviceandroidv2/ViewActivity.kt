package com.example.libraryserviceandroidv2

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.adapters.ViewGamesRecyclerAdapter
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
import kotlinx.coroutines.launch

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.cardviewgameslayout)

        lifecycleScope.launch {
            var gameList = MyDataBaseBuilder.getInstance(applicationContext).gameDao().getAll()

            var f = findViewById<RecyclerView>(R.id.cardviewviewlayout)

            val linearLayoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            f.layoutManager = linearLayoutManager
            f.adapter = ViewGamesRecyclerAdapter(gameList)
        }

    }

}