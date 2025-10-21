package com.example.graduationproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.graduationproject.ui.screens.AppNavigation
import com.example.graduationproject.ui.screens.BottomBarNav
import com.example.graduationproject.ui.screens.MainScreen
import com.example.graduationproject.ui.theme.GraduationProjectTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraduationProjectTheme() {
                BottomBarNav()
            }
        }
    }
}

