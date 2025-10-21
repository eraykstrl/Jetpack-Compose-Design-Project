package com.example.graduationproject.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(startDest : String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDest) {
        composable("mainscreen") {
            MainScreen()
        }
    }
}