package com.example.healthapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthapp.ui.screens.UserProfileScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "userProfile"
    ) {
        composable("userProfile") {
            UserProfileScreen()
        }
    }
} 