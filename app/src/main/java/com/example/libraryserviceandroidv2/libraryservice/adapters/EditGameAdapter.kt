package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView

class EditGameAdapter : AdapterView.OnItemSelectedListener  {
    private lateinit var itemAtPosition : String

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        itemAtPosition = parent?.getItemAtPosition(position).toString()
        System.out.println("smurf")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        System.out.println("smurf")
    }
}