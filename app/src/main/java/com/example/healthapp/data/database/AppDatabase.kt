package com.example.healthapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.healthapp.data.dao.UserDao
import com.example.healthapp.data.model.GenderConverter
import com.example.healthapp.data.model.User

@Database(entities = [User::class], version = 1)
@TypeConverters(GenderConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
} 