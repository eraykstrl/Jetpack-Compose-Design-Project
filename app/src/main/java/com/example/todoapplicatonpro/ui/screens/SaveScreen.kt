package com.example.todoapplicatonpro.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapplicatonpro.R
import com.example.todoapplicatonpro.ui.components.CustomButton
import com.example.todoapplicatonpro.ui.components.CustomOutlinedTextField
import com.example.todoapplicatonpro.ui.components.CustomTopAppBar
import com.example.todoapplicatonpro.ui.viewmodels.SaveViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveScreen(
    saveViewModel: SaveViewModel
) {

    val newActivity = remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                topText = stringResource(id = R.string.save_screen_title)
            )
        },
        snackbarHost = {
                SnackbarHost(snackbarHostState)
        }
    ) {
        pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .padding(all = 8.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.hello_message),
                color = colorResource(id = R.color.burgundy),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier
                .size(50.dp))

            CustomOutlinedTextField(
                hint = stringResource(id = R.string.new_activity_text),
                value = newActivity.value,
                onValueChange = {
                    newActivity.value = it
                },
                isThereIcon = false
            )

            Spacer(modifier = Modifier
                .size(50.dp))

            CustomButton(
                onButtonClick = {
                    coroutineScope.launch {
                        val sb = snackbarHostState
                            .showSnackbar(
                                message = context.getString(
                                    R.string.snackbar_save_message
                                ),
                                actionLabel = "Yes"
                            )

                        if(sb == SnackbarResult.ActionPerformed) {
                            saveViewModel.saveNewToDos(newActivity.value)
                        }
                    }
                },
                toDoName = stringResource(id = R.string.save_button_text),
                enable = if(newActivity.value.isNotBlank()) true else false
            )

        }
    }

}