package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.content.Context
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

class ResultSpinnerItemSelectedAdapter(
    var gameList: List<GameModel>,
    var recyclerView: RecyclerView,
    var context: Context,
    var layoutManager: RecyclerView.LayoutManager,
    var isGenre: Int,
    var isPreOrder: Int
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var str = parent?.getItemAtPosition(position) as String

        gameList = GameList.getGameList()

        if(isGenre == 0) {
            var toList = gameList
                .filter { e -> e.gameGenre.contentEquals(str) }
                .filter { e -> e.preOrdered == false }
                .toList()

            handleList(toList)
        } else {
            var toList = gameList
                .filter { e -> e.platform.contentEquals(str) }
                .filter { e -> e.preOrdered == false }

            handleList(toList)
        }
    }

    private fun handleList(toList: List<GameModel>) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ViewGamesRecyclerAdapter(toList)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}