package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView
import com.example.libraryserviceandroidv2.libraryservice.adapters.gameobjects.PlatformText

class PlatformSpinnerAdapter() : AdapterView.OnItemSelectedListener {
    lateinit var itemAtPosition : String

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        itemAtPosition = p0?.getItemAtPosition(p2).toString()
        PlatformText.setPlatform(itemAtPosition)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        System.out.println("smurf2")
    }
}