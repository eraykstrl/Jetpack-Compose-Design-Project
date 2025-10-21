package com.example.todoapplicatonpro.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todoapplicatonpro.R

@Composable
fun CustomToDoItem(
    toDoName : String,
    onButtonClick : () -> Unit,
    enable : Boolean,
    onDeleteClick : () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .padding(horizontal = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(width = 2.dp, color = colorResource(id = R.color.burgundy), shape = RoundedCornerShape(12.dp))
        ) {

            CustomButton(
                onButtonClick = {
                    onButtonClick()
                },
                toDoName = toDoName,
                enable = enable
            )

            IconButton(
                onClick = {
                    onDeleteClick()
                }
            ) {
                Icon(
                    Icons.Filled.Clear,
                    contentDescription = stringResource(id = R.string.delete_text),
                    modifier = Modifier.size(20.dp),
                    tint = colorResource(id = R.color.blue)
                )
            }
        }

    }
}