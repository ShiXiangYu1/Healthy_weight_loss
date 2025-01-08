package com.example.healthapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val age: Int,
    val height: Float,
    val weight: Float,
    val targetWeight: Float,
    @TypeConverters(GenderConverter::class)
    val gender: Gender
) 