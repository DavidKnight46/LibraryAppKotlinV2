package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.content.Context
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import kotlin.streams.toList

class ResultSpinnerItemSelectedAdapter(
    var gameList: List<GameModel>,
    var recyclerView: RecyclerView,
    var context: Context,
    var layoutManager: RecyclerView.LayoutManager,
    var isGenre: Int,
    var isPreOrder: Boolean
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var str = parent?.getItemAtPosition(position) as String

        if(str.equals("Yes")) {
            handleList(gameList.stream()
                .filter { e -> e.isPreOrdered == isPreOrder }
                .toList())
        } else if (isGenre == 0) {
            handleList(gameList
                .filter { e -> e.gameGenre.contentEquals(str) }
                .toList())
        } else if(isGenre == 1) {
            handleList(gameList
                .filter { e -> e.platform.contentEquals(str) }
                .toList())
        } else {
            handleList(gameList)
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