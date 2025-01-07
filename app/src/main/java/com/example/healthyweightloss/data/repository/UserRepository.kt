package com.example.healthyweightloss.data.repository

import com.example.healthyweightloss.data.dao.UserDao
import com.example.healthyweightloss.data.model.User
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    val user: Flow<User?> = userDao.getUser()

    suspend fun saveUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }
} 