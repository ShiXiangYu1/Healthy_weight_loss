package com.example.healthyweightloss.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.healthyweightloss.data.model.Gender
import com.example.healthyweightloss.ui.viewmodels.UserProfileViewModel

@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel = hiltViewModel()
) {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf(Gender.MALE) }
    var targetWeight by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("身高 (cm)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("体重 (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("年龄") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RadioButton(
                selected = gender == Gender.MALE,
                onClick = { gender = Gender.MALE }
            )
            Text("男")
            RadioButton(
                selected = gender == Gender.FEMALE,
                onClick = { gender = Gender.FEMALE }
            )
            Text("女")
        }

        OutlinedTextField(
            value = targetWeight,
            onValueChange = { targetWeight = it },
            label = { Text("目标体重 (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.saveUserInfo(
                    height = height.toFloatOrNull() ?: 0f,
                    weight = weight.toFloatOrNull() ?: 0f,
                    age = age.toIntOrNull() ?: 0,
                    gender = gender
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("保存")
        }
    }
} 