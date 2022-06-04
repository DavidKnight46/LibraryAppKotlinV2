package com.example.libraryserviceandroidv2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryserviceandroidv2.libraryservice.database.AppDatabase
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.IsAdded
import com.google.android.material.textfield.TextInputEditText

class EditActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IsAdded.setIsAdded(false)

        setContentView(R.layout.layouteditactivity)

        System.out.println("smurf")
    }
}