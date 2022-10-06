package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Switch
import androidx.fragment.app.FragmentContainerView
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import com.google.android.material.textfield.TextInputEditText

class EditGamesAdapter(
    val genreList: List<String>,
    val platformList: List<String>,
    val list: List<GameModel>,
    var fragment: FragmentContainerView
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var gameModel = list[position]

        setTextInput(fragment.findViewById(R.id.gameNameInput1), gameModel.gameName)
        setTextInput(fragment.findViewById(R.id.releaseDateInput), gameModel.releaseDate)
        setTextInput(fragment.findViewById(R.id.imageUrlInput), gameModel.imageUrl)

        fragment.findViewById<RatingBar>(R.id.ratingBar).rating = gameModel.gameRating
        fragment.findViewById<Switch>(R.id.preOrderSwitchAdd).isChecked = gameModel.isPreOrdered

        fragment.findViewById<Spinner>(R.id.platFormSpinner)
            .setSelection(setPlatformSpinnerInt(gameModel))
        fragment.findViewById<Spinner>(R.id.genreSpinner)
            .setSelection(setGenreSpinnerInt(gameModel))
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    private fun setTextInput(inputEdit: TextInputEditText, text: String) {
        inputEdit.setText(text)
    }

    private fun setPlatformSpinnerInt(gameModel: GameModel): Int {
        return createHashMapFromArray(platformList).getValue(gameModel.platform);
    }

    private fun setGenreSpinnerInt(gameModel: GameModel): Int {
        return createHashMapFromArray(genreList).getValue(gameModel.gameGenre)
    }

    private fun createHashMapFromArray(theList: List<String>): HashMap<String, Int> {
        var hashMapOf = hashMapOf<String, Int>();

        var i = 0

        theList.forEach { e ->
            hashMapOf.put(e, i)
            i++
        }

        return hashMapOf
    }
}