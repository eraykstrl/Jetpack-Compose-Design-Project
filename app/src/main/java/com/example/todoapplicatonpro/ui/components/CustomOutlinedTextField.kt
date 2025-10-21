package com.example.todoapplicatonpro.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.todoapplicatonpro.R

@Composable
fun CustomOutlinedTextField(
    hint : String,
    value : String,
    onValueChange : (String) -> Unit,
    isThereIcon : Boolean
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(
                text = hint
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = colorResource(id = R.color.blue),
            focusedIndicatorColor = colorResource(id = R.color.burgundy),
        ),
        leadingIcon = {
            if(isThereIcon) {
                Icon(
                    Icons.Filled.Search,
                    tint = colorResource(id = R.color.blue),
                    contentDescription = stringResource(id = R.string.search_text)
                )
            }
        }
    )
}