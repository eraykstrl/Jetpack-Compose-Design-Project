package com.example.graduationproject.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.graduationproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {

    CenterAlignedTopAppBar(
        title = {

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.white)
        ),
    )
}