package com.example.graduationproject.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Categories

@Composable
fun CustomOutlinedTextField() {
    val isSelected = remember { mutableStateOf(false) }


    val categoriesList = listOf(
        Categories(1, "Kategoriler"),
        Categories(2, "Kadın"),
        Categories(3, "Erkek"),
        Categories(4, "Kozmetik"),
        Categories(5, "Ev & Yaşam"),
        Categories(6, "Süpermarket"),
        Categories(7, "Anne & Çocuk"),
        Categories(8, "Saat & Aksesuar"),
        Categories(9, "Elektronik"),
        Categories(10, "Ayakkabı & Çanta"),
        Categories(11, "Spor & Outdoor"),
        Categories(12, "Markalar"),
        Categories(13, "İndirimler"),
        Categories(14, "Avantajlar")
    )

    val categories= remember { mutableStateOf(categoriesList) }


    val searchQuery = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            OutlinedTextField(
                value = searchQuery.value,
                onValueChange = {
                    searchQuery.value = it
                },
                placeholder = {
                    Text(
                        text = stringResource(id =R.string.search_text ) ,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription =stringResource(id =R.string.search_bar_info )   ,
                        tint = colorResource(id = R.color.orange)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.camera_icon),
                        contentDescription =stringResource(id = R.string.search_with_camera),
                        modifier = Modifier.size(32.dp),
                        tint = Color.Unspecified
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.gray),
                    unfocusedContainerColor = colorResource(id = R.color.gray),
                    disabledContainerColor = colorResource(id = R.color.gray),
                    focusedLabelColor = colorResource(id = R.color.black),
                    cursorColor = colorResource(id = R.color.orange),
                    focusedBorderColor = colorResource(id = R.color.dark_gray),
                    unfocusedBorderColor = colorResource(id = R.color.dark_gray),
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .weight(1f)
                    .height(52.dp)
                    .border(width = 2.dp, color = colorResource(id = R.color.dark_gray), shape = RoundedCornerShape(24.dp))
            )

            Icon(
                Icons.Filled.MailOutline,
                contentDescription =stringResource(id = R.string.messages_text),
                tint = colorResource(id = R.color.black),
                modifier = Modifier.size(32.dp)
            )
            Icon(
                Icons.Filled.Notifications,
                contentDescription =stringResource(id = R.string.notification_text),
                tint = colorResource(id = R.color.black),
                modifier = Modifier.size(32.dp)
            )
        }

        val selectedItem = remember { mutableStateOf<Int?>(null) }

        LazyRow(
            modifier = Modifier
                .padding(vertical = 8.dp)
        ) {
            items(
                count = categories.value.size
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                val it = categories.value[it]

                CustomOutlinedButton(
                    category = it,
                    onButtonClick = {
                        selectedItem.value = it.id
                    },
                    isSelected = selectedItem.value == it.id,
                )
            }
        }

    }


}