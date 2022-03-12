package com.example.libraryserviceandroidv2.libraryservice.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity

@Database(entities = [GameEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDAO
}