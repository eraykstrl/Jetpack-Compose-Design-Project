package com.example.todoapplicatonpro.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapplicatonpro.data.entity.ToDo
import com.example.todoapplicatonpro.ui.viewmodels.MainViewModel
import com.example.todoapplicatonpro.ui.viewmodels.SaveViewModel
import com.example.todoapplicatonpro.ui.viewmodels.UpdateViewModel
import com.google.gson.Gson

@Composable
fun AppNavigation(mainViewModel: MainViewModel,saveViewModel: SaveViewModel,updateViewModel: UpdateViewModel) {

    val navController = rememberNavController()

    NavHost(navController, startDestination = "mainscreen") {

        composable("mainscreen") {
            MainScreen(
                navController,
                mainViewModel = mainViewModel
            )
        }

        composable("savescreen") {

            SaveScreen(saveViewModel = saveViewModel)
        }

        composable("updatescreen/{toDo}",
            arguments = listOf(
                navArgument("toDo") { type = NavType.StringType }
            )
            ) {

            val toDoString = it.arguments?.getString("toDo")
            val toDoFromJson = Gson().fromJson(toDoString, ToDo::class.java)

            UpdateScreen(
                updateViewModel = updateViewModel,
                toDo = toDoFromJson
            )
        }
    }
}