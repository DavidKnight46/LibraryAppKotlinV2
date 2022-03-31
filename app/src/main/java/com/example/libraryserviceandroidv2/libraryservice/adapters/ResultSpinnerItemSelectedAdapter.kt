package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.content.Context
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList

class ResultSpinnerItemSelectedAdapter(
    var gameList: List<GameEntity>,
    var recyclerView: RecyclerView,
    var context: Context,
    var layoutManager: RecyclerView.LayoutManager,
    var isGenre: Boolean
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var str = parent?.getItemAtPosition(position) as String

        if(isGenre) {
            var toList = gameList.filter { e -> e.gameGenre.contentEquals(str) }.toList()
            GameList.setGameList(toList)

            handleList(toList)
        } else {
            var toList = gameList.filter { e -> e.gamePlatform.contentEquals(str) }.toList()
            GameList.setGameList(toList)

            handleList(toList)
        }
    }

    private fun handleList(toList: List<GameEntity>) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ViewGamesRecyclerAdapter(toList)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}