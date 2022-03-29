package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.R
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity

class CardViewFilterAdapter(
    var resultSpinner: Spinner,
    var context: Context,
    var gameList: List<GameEntity>,
    var recyclerView: RecyclerView,
    var layoutManager: RecyclerView.LayoutManager
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var type = parent?.getItemAtPosition(position) as String

        if (type.contentEquals("Genre")) {
            resultSpinner.adapter =
                createAdapter(arrayOf("Action/Adventure", "RPG", "FPS", "Fighting", "RTS"))

            resultSpinner.onItemSelectedListener = ResultSpinnerItemSelectedAdapter(gameList, recyclerView, context, layoutManager)

        } else if (type.contentEquals("Platform")) {
            resultSpinner.adapter =
                createAdapter(arrayOf("PS1", "PS2", "PS3", "PS4", "PS5", "PSP", "PSVita"))

            resultSpinner.onItemSelectedListener = ResultSpinnerItemSelectedAdapter(gameList, recyclerView, context, layoutManager)
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