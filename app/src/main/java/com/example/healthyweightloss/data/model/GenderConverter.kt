package com.example.healthyweightloss.data.model

import androidx.room.TypeConverter

class GenderConverter {
    @TypeConverter
    fun fromGender(gender: Gender): String {
        return gender.name
    }

    @TypeConverter
    fun toGender(value: String): Gender {
        return Gender.valueOf(value)
    }
} 