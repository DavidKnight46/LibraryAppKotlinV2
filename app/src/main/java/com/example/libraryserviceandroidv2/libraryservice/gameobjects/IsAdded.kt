package com.example.libraryserviceandroidv2.libraryservice.gameobjects

object IsAdded {

    var isAdded: Boolean = false;

    fun getIsAdded(): Boolean {
        return isAdded
    }

    fun setIsAdded(isAdded: Boolean) {
        this.isAdded = isAdded;
    }
}