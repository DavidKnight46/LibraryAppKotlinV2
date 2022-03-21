package com.example.libraryserviceandroidv2.libraryservice.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class GameEntity(@PrimaryKey(autoGenerate = true) val id: Int,
                      @ColumnInfo(name = "game_name") var gameName: String,
                      @ColumnInfo(name = "game_genre") var gameGenre: String,
                      @ColumnInfo(name = "game_platform") val gamePlatform: String,
                      @ColumnInfo(name = "game_rating") val rating: Float,
                      @ColumnInfo(name = "release_date") val releaseDate: String,
                      @ColumnInfo(name = "image_url") val imageUri: String){
    override fun toString(): String {
        return "$gameName : $gamePlatform"
    }
}
