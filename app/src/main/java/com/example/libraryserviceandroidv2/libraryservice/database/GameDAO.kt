package com.example.libraryserviceandroidv2.libraryservice.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity

@Dao
interface GameDAO {

    @Query("SELECT * FROM gameentity")
    suspend fun getAll(): List<GameEntity>

    @Insert
    suspend fun insertAll(vararg users: GameEntity)
}