package com.example.libraryserviceandroidv2.libraryservice.database

import androidx.room.*
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity

@Dao
interface GameDAO {

    @Query("SELECT * FROM gameentity")
    suspend fun getAll(): List<GameEntity>

    @Query("SELECT * FROM gameentity WHERE id is :idGame")
    suspend fun getAnGame(idGame: Long): GameEntity

    @Insert
    suspend fun insertAll(vararg users: GameEntity)

    @Delete
    suspend fun delete(vararg users: GameEntity)

    @Update
    suspend fun update(vararg users: GameEntity)
}