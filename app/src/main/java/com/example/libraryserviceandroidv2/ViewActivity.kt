package com.example.libraryserviceandroidv2

import android.os.Bundle
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.adapters.CardViewFilterAdapter
import com.example.libraryserviceandroidv2.libraryservice.adapters.ViewGamesRecyclerAdapter
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.IsPreOrder
import kotlinx.coroutines.launch
import java.util.*

class ViewActivity : AppCompatActivity() {

    lateinit var isPreOrder: Integer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.cardviewgameslayout)

        var preOrderSwitch = findViewById<Switch>(R.id.preOrderSwitch)
        IsPreOrder.setIsPreOrder(Integer(1))

        preOrderSwitch.setOnClickListener {
            if(preOrderSwitch.isChecked){
                IsPreOrder.setIsPreOrder(Integer(0))
            }

            lifecycleScope.launch {
                foo()
            }
        }

        lifecycleScope.launch {
            foo()
        }

    }

    private fun foo() {
        var cardviewviewlayout = findViewById<RecyclerView>(R.id.cardviewviewlayout)

        val linearLayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        var findViewById = findViewById<Spinner>(R.id.viewFilterTypes)
        findViewById.onItemSelectedListener = CardViewFilterAdapter(
            findViewById(R.id.viewFilterResults),
            applicationContext,
            Collections.emptyList(),
            cardviewviewlayout,
            linearLayoutManager,
            IsPreOrder.getIsPreOrder().toInt()
        )

        cardviewviewlayout.layoutManager = linearLayoutManager
        cardviewviewlayout.adapter = ViewGamesRecyclerAdapter(GameList.getGameList())
    }


}