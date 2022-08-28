package com.example.libraryserviceandroidv2.libraryservice.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameEntity(@PrimaryKey(autoGenerate = true) val id: Int,
                      @ColumnInfo(name = "game_name") var gameName: String,
                      @ColumnInfo(name = "game_genre") var gameGenre: String,
                      @ColumnInfo(name = "game_platform") var gamePlatform: String,
                      @ColumnInfo(name = "game_rating") val rating: Float,
                      @ColumnInfo(name = "release_date") var releaseDate: String,
                      @ColumnInfo(name = "image_url") var imageUri: String,
                      @ColumnInfo(name = "preordered") var preOrder: Int){
    override fun toString(): String {
        return "$gameName : $gamePlatform"
    }
}
