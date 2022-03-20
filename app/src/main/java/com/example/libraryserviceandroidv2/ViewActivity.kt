package com.example.libraryserviceandroidv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.databinding.ActivityMainBinding
import com.example.libraryserviceandroidv2.databinding.ActivityviewlayoutBinding
import com.example.libraryserviceandroidv2.libraryservice.adapters.ViewGamesRecyclerAdapter
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
import kotlinx.coroutines.launch

class ViewActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityviewlayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityviewlayoutBinding.inflate(layoutInflater)

        setContentView(R.layout.cardviewgameslayout)

        lifecycleScope.launch {
            var gameList = MyDataBaseBuilder.getInstance(applicationContext).gameDao().getAll()

            var f = findViewById<RecyclerView>(R.id.cardviewviewlayout)
            f.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)

            f.adapter = ViewGamesRecyclerAdapter(gameList)

            System.out.println("smurf2")
        }
    }
}