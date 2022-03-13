package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.View
import android.widget.AdapterView

class PlatformSpinnerAdapter() : AdapterView.OnItemSelectedListener {
    private lateinit var itemAtPosition : String

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        itemAtPosition = p0?.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        System.out.println("smurf2")
    }

    fun getPlatformName(): String{
        return itemAtPosition
    }
}