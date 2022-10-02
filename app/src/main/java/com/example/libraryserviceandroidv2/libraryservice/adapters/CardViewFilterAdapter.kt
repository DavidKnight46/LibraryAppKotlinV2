package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.R
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

class CardViewFilterAdapter(
    var platFormArray: Array<String>,
    var genreArray: Array<String>,
    var resultSpinner: Spinner,
    var context: Context,
    var gameList: List<GameModel>,
    var recyclerView: RecyclerView,
    var layoutManager: RecyclerView.LayoutManager,
    var isPreOrder: Boolean
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var type = parent?.getItemAtPosition(position) as String

        if (type.contentEquals("Genre")) {
            resultSpinner.adapter =
                createAdapter(genreArray)

            resultSpinner.onItemSelectedListener = ResultSpinnerItemSelectedAdapter(
                gameList,
                recyclerView,
                context,
                layoutManager,
                0,
                isPreOrder
            )

        } else if (type.contentEquals("Platform")) {
            resultSpinner.adapter =
                createAdapter(platFormArray)

            resultSpinner.onItemSelectedListener = ResultSpinnerItemSelectedAdapter(
                gameList,
                recyclerView,
                context,
                layoutManager,
                1,
                isPreOrder
            )
        } else if(type.equals("Pre-Ordered")){
            resultSpinner.adapter =
                createAdapter(arrayOf("Yes"))

            resultSpinner.onItemSelectedListener = ResultSpinnerItemSelectedAdapter(
                gameList,
                recyclerView,
                context,
                layoutManager,
                1,
                true
            )
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun createAdapter(items: Array<String>): ArrayAdapter<String> {
        return ArrayAdapter(
            context,
            R.layout.simple_spinner_item,
            items
        )
    }
}