package com.example.libraryserviceandroidv2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryserviceandroidv2.libraryservice.adapters.EditGamesAdapter
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.IsAdded

class EditActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IsAdded.setIsAdded(false)

        setContentView(R.layout.layouteditactivity)

        var findViewById = findViewById<Spinner>(R.id.gamesToEdit)

        findViewById.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, GameList.getGameList())
        findViewById.onItemSelectedListener = EditGamesAdapter(GameList.getGameList())

    }
}