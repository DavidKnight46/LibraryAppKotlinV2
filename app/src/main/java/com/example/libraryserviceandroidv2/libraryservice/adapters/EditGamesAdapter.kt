package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

class EditGamesAdapter(val list: List<GameModel>) :  AdapterView.OnItemSelectedListener{
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        println("smurf")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        println("smurf")
    }
}