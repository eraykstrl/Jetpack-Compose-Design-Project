package com.example.todoapplicatonpro.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapplicatonpro.R
import com.example.todoapplicatonpro.data.entity.ToDo
import com.example.todoapplicatonpro.ui.components.CustomAlertDialog
import com.example.todoapplicatonpro.ui.components.CustomButton
import com.example.todoapplicatonpro.ui.components.CustomOutlinedTextField
import com.example.todoapplicatonpro.ui.components.CustomTopAppBar
import com.example.todoapplicatonpro.ui.viewmodels.UpdateViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    updateViewModel: UpdateViewModel,
    toDo : ToDo
) {
    val updatedToDosName = remember { mutableStateOf(toDo.name) }
    val showAlert = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CustomTopAppBar(
                topText = stringResource(id = R.string.update_screen_title)
            )
        }
    ) { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .padding(all = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.update_screen_saying),
                color = colorResource(id = R.color.burgundy),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.size(50.dp))

            CustomOutlinedTextField(
                hint = stringResource(id = R.string.update_text),
                value = updatedToDosName.value,
                onValueChange = {
                    updatedToDosName.value = it
                },
                isThereIcon = false
            )
            Spacer(modifier = Modifier.size(50.dp))

            CustomButton(
                onButtonClick = {
                    showAlert.value = true
                },
                toDoName = stringResource(id = R.string.update_button_text),
                enable = if (updatedToDosName.value.trim() == toDo.name) false else true
            )

            CustomAlertDialog(
                show = showAlert.value,
                onDismiss = { showAlert.value = false },
                onConfirm = {
                    updateViewModel.updateCurrentToDos(id = toDo.id,updatedToDosName.value)
                    showAlert.value = false
                },
                message = stringResource(id = R.string.alert_update_text)
            )
        }
    }
}


