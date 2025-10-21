package com.example.todoapplicatonpro.ui.screens

import androidx.compose.foundation.background
import com.example.todoapplicatonpro.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapplicatonpro.ui.components.CustomOutlinedTextField
import com.example.todoapplicatonpro.ui.components.CustomToDoItem
import com.example.todoapplicatonpro.ui.components.CustomTopAppBar
import com.example.todoapplicatonpro.ui.viewmodels.MainViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel
) {

    val snackbarHostState= remember { SnackbarHostState() }
    val searchText = remember { mutableStateOf("") }
    val allList = mainViewModel.toDosList.observeAsState(listOf())

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current


    LaunchedEffect(
        key1 = true
    ) {
        mainViewModel.getAll()
    }

    Scaffold(
        topBar = {
            CustomTopAppBar(
                topText = stringResource(id = R.string.main_screen_title)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("savescreen")
                },
                containerColor = colorResource(
                    id = R.color.burgundy
                ),
                content = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Go to Save Screen",
                        tint = colorResource(
                            id = R.color.white
                        )
                    )
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            CustomOutlinedTextField(
                hint = stringResource(id = R.string.search_text),
                value = searchText.value,
                onValueChange = {
                    searchText.value = it
                    mainViewModel.searchToDos(it)
                },
                isThereIcon = true
            )

            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                items(
                    count = allList.value.size
                ) {
                    val toDo = allList.value[it]
                    CustomToDoItem(
                        toDo.name,
                        onButtonClick = {
                            val jsonObject = Gson().toJson(toDo)
                            navController.navigate("updatescreen/$jsonObject")
                        },
                        enable = true,
                        onDeleteClick = {
                            coroutineScope.launch {
                                val sb = snackbarHostState.showSnackbar(
                                    message = context.getString(
                                        R.string.snackbar_delete_message
                                    ),
                                    actionLabel = "Yes"
                                )

                                if(sb == SnackbarResult.ActionPerformed) {
                                    mainViewModel.deleteToDos(toDo.id)
                                }
                            }
                        }
                    )

                }

            }

        }
    }
}