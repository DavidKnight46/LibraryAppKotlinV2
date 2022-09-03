package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView
import android.widget.RatingBar
import android.widget.Switch
import androidx.fragment.app.FragmentContainerView
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import com.google.android.material.textfield.TextInputEditText

class EditGamesAdapter(val list: List<GameModel>,
                       var fragment: FragmentContainerView) :  AdapterView.OnItemSelectedListener{
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var gameModel = list.get(position)

        setTextInput(fragment.findViewById(R.id.gameNameInput1), gameModel.name)
        setTextInput(fragment.findViewById(R.id.releaseDateInput), gameModel.releaseDate)
        setTextInput(fragment.findViewById(R.id.imageUrlInput), gameModel.imageUrl)

        fragment.findViewById<RatingBar>(R.id.ratingBar).rating = gameModel.gameRating
        fragment.findViewById<Switch>(R.id.preOrderSwitchAdd).isChecked = gameModel.preOrdered
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        println("smurf")
    }

    private fun setTextInput(inputEdit : TextInputEditText, text: String){
        inputEdit.setText(text)
    }
}