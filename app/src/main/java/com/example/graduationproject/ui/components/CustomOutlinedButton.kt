package com.example.graduationproject.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Categories

@Composable
fun CustomOutlinedButton(
    category : Categories,
    onButtonClick : () -> Unit,
    isSelected : Boolean = false
) {

    Log.e("CUSTOM OUTLINE ","$isSelected")

    OutlinedButton(
        onClick = {
            onButtonClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isSelected) colorResource(id = R.color.orange) else colorResource(id = R.color.white) ,
            contentColor = colorResource(id = R.color.black),
            ),
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.dark_gray)
        ),
    ) {

        if(category.id == 1) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = stringResource(id = R.string.categories_text)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }

        Text(
            category.name,
            fontSize = 14.sp,
            color = colorResource(id = R.color.dark_gray)
        )
    }
}