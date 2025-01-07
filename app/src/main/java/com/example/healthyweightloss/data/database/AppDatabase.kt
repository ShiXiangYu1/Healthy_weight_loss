package com.example.healthyweightloss.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.healthyweightloss.data.dao.UserDao
import com.example.healthyweightloss.data.model.User
import com.example.healthyweightloss.data.model.GenderConverter

@Database(entities = [User::class], version = 1)
@TypeConverters(GenderConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "healthy_weight_loss_db"
    }
} 