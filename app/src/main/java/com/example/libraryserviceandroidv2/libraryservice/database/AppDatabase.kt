package com.example.libraryserviceandroidv2.libraryservice.database

import androidx.room.Database
import androidx.room.Insert
import androidx.room.RoomDatabase
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity

@Database(entities = [GameEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    @Insert
    abstract fun gameDao(): GameDAO
}