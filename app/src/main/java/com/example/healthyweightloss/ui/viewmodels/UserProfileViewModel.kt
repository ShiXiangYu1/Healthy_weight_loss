package com.example.healthyweightloss.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyweightloss.data.model.Gender
import com.example.healthyweightloss.data.model.User
import com.example.healthyweightloss.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val user = userRepository.user

    fun saveUserInfo(height: Float, weight: Float, age: Int, gender: Gender) {
        viewModelScope.launch {
            val user = User(
                height = height,
                weight = weight,
                age = age,
                gender = gender
            )
            userRepository.saveUser(user)
        }
    }

    fun calculateBMI(height: Float, weight: Float): Float {
        val heightInMeters = height / 100
        return weight / (heightInMeters * heightInMeters)
    }

    fun getBMIStatus(bmi: Float): String {
        return when {
            bmi < 18.5 -> "体重过轻"
            bmi < 24 -> "体重正常"
            bmi < 28 -> "超重"
            else -> "肥胖"
        }
    }
} 