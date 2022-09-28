package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.PlatformText

class PlatformSpinnerAdapter(val platformSpinner: Spinner) : AdapterView.OnItemSelectedListener {
    lateinit var itemAtPosition: String

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        itemAtPosition = p0?.getItemAtPosition(p2).toString()
        PlatformText.setPlatform(itemAtPosition)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        System.out.println("smurf2")
    }
}