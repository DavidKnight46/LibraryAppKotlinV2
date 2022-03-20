package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView
import android.widget.Button
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import com.google.android.material.textfield.TextInputEditText

class EditGameAdapter(
    gameName: TextInputEditText,
    releaseDateText: TextInputEditText,
    imageUrl: TextInputEditText,
    updateButton: Button
) : AdapterView.OnItemSelectedListener {
    private lateinit var itemAtPosition: GameEntity
    private var gameName: TextInputEditText = gameName
    private var releaseDate: TextInputEditText = releaseDateText
    private var imageUrl: TextInputEditText = imageUrl
    private var updateButton = updateButton

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        itemAtPosition = parent?.getItemAtPosition(position) as GameEntity

        gameName.setText(itemAtPosition.gameName)
        releaseDate.setText(itemAtPosition.releaseDate)
        imageUrl.setText(itemAtPosition.imageUri)
        updateButton.setText("Update")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        System.out.println("smurf")
    }
}