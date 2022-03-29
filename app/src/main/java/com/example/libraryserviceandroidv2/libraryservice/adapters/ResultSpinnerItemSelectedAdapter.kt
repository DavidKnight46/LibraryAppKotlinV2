package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.content.Context
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity

class ResultSpinnerItemSelectedAdapter(
    var gameList: List<GameEntity>,
    var recyclerView: RecyclerView,
    var context: Context,
    var layoutManager: RecyclerView.LayoutManager
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var str = parent?.getItemAtPosition(position) as String

        var toList = gameList.filter { e -> e.gameGenre.contentEquals(str) }.toList()

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ViewGamesRecyclerAdapter(toList)

        //System.out.println("smurf")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}