package com.example.libraryserviceandroidv2.libraryservice.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class GameEntity(@PrimaryKey val id: Int,
                      @ColumnInfo(name = "game_name") val gameName: String,
                      @ColumnInfo(name = "game_genre") val gameGenre: String,
                      @ColumnInfo(name = "game_platform") val gamePlatform: String,
                      @ColumnInfo(name = "game_rating") val rating: Float,
                      @ColumnInfo(name = "release_date") val releaseDate: LocalDate,
                      @ColumnInfo(name = "image_url") val imageUri: String)
