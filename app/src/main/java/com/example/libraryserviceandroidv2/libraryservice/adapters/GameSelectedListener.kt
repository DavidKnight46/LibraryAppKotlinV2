package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.RatingBar
import android.widget.Spinner
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import com.google.android.material.textfield.TextInputEditText

class GameSelectedListener(
    gameName: TextInputEditText,
    releaseDateText: TextInputEditText,
    imageUrl: TextInputEditText,
    updateButton: Button,
    ratingBar: RatingBar,
    platformSpinner: Spinner,
    genreSpinner: Spinner
) : AdapterView.OnItemSelectedListener {
    private lateinit var itemAtPosition: GameEntity
    private var gameName: TextInputEditText = gameName
    private var releaseDate: TextInputEditText = releaseDateText
    private var imageUrl: TextInputEditText = imageUrl
    private var updateButton = updateButton
    private var ratingBar: RatingBar = ratingBar
    private var platformSpinner = platformSpinner
    private var genreSpinner = genreSpinner

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        itemAtPosition = parent?.getItemAtPosition(position) as GameEntity

        setFields(itemAtPosition)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    fun getGame(): GameEntity {
        return itemAtPosition
    }

    private fun setFields(gameEntity: GameEntity) {
        gameName.setText(itemAtPosition.gameName)
        releaseDate.setText(itemAtPosition.releaseDate)
        imageUrl.setText(itemAtPosition.imageUri)
        updateButton.setText(R.string.editGame)
        ratingBar.numStars = ratingBar.numStars

        platformSpinner.setSelection(getSpinnerNumber(gameEntity, true))
        genreSpinner.setSelection(getSpinnerNumber(gameEntity, false))

    }

    private fun getSpinnerNumber(gameEntity: GameEntity, isPlatform: Boolean): Int {
        var postion: Int = 0

        if (isPlatform) {
            if (gameEntity.gamePlatform == "PS1") {
                postion = 0
            } else if (gameEntity.gamePlatform == "PS2") {
                postion = 1
            } else if (gameEntity.gamePlatform == "PS3") {
                postion = 2
            } else if (gameEntity.gamePlatform == "PS4") {
                postion = 3
            } else if (gameEntity.gamePlatform == "PS5") {
                postion = 4
            }
        } else {
            if (gameEntity.gameGenre == "Action/Adventure") {
                postion = 0
            } else if (gameEntity.gameGenre == "RPG") {
                postion = 1
            } else if (gameEntity.gameGenre == "FPS") {
                postion = 2
            } else if (gameEntity.gameGenre == "Fighting") {
                postion = 3
            } else if (gameEntity.gameGenre == "RTS") {
                postion = 4
            }
        }

        return postion
    }
}