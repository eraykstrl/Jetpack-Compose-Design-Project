package com.example.todoapplicatonpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.todoapplicatonpro.ui.screens.AppNavigation
import com.example.todoapplicatonpro.ui.theme.ToDoApplicatonProTheme
import com.example.todoapplicatonpro.ui.viewmodels.MainViewModel
import com.example.todoapplicatonpro.ui.viewmodels.SaveViewModel
import com.example.todoapplicatonpro.ui.viewmodels.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel : MainViewModel by viewModels()
    val saveViewModel : SaveViewModel by viewModels()
    val updateViewModel : UpdateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoApplicatonProTheme {
                AppNavigation(
                    mainViewModel = mainViewModel,
                    saveViewModel = saveViewModel,
                    updateViewModel = updateViewModel
                    )
            }
        }
    }
}

