package com.example.healthyweightloss.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: Int = 1,  // 单用户模式，固定ID为1
    var height: Float,  // 身高(cm)
    var weight: Float,  // 体重(kg)
    var age: Int,      // 年龄
    var gender: Gender,  // 性别
    var targetWeight: Float? = null  // 目标体重
) 