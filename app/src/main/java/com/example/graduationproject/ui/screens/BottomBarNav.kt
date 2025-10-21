package com.example.graduationproject.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.graduationproject.R


@Composable
fun BottomBarNav() {
    val selectedItem = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(id = R.color.white),
            ) {
                NavigationBarItem(
                    selected = selectedItem.value == 0,
                    onClick = {
                        selectedItem.value =0
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = stringResource(id =R.string.home_screen_text),
                            tint = colorResource(id = R.color.orange),
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = stringResource(id =R.string.home_screen_text),
                            color = colorResource(id = R.color.black)
                        )
                    }
                )

                NavigationBarItem(
                    selected = selectedItem.value == 0,
                    onClick = {
                        selectedItem.value =0
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = stringResource(id =R.string.go_text),
                            tint = colorResource(id = R.color.black),
                            modifier = Modifier
                                .size(24.dp)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                    label = {
                        Text(text = stringResource(id =R.string.go_text),
                            color = colorResource(id = R.color.black)
                        )

                    }
                )

                NavigationBarItem(
                    selected = selectedItem.value == 0,
                    onClick = {
                        selectedItem.value =0
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = stringResource(id =R.string.my_favorite_text),
                            tint = colorResource(id = R.color.black),
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = stringResource(id =R.string.my_favorite_text),
                            color = colorResource(id = R.color.black)
                        )
                    }
                )

                NavigationBarItem(
                    selected = selectedItem.value == 0,
                    onClick = {
                        selectedItem.value =0
                    },
                    icon = {
                        Icon(
                            Icons.Filled.ShoppingCart,
                            contentDescription = stringResource(id =R.string.my_card_text),
                            tint = colorResource(id = R.color.black),
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text =  stringResource(id =R.string.my_card_text),
                            color = colorResource(id = R.color.black)
                        )
                    }
                )

                NavigationBarItem(
                    selected = selectedItem.value == 0,
                    onClick = {
                        selectedItem.value =0
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = stringResource(id =R.string.my_account_text),
                            tint = colorResource(id = R.color.black),
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = stringResource(id =R.string.my_account_text),
                            color = colorResource(id = R.color.black)
                        )
                    }
                )
            }
        }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())

        ) {
            if (selectedItem.value == 0) {
                AppNavigation("mainscreen")
            }
        }

    }

}