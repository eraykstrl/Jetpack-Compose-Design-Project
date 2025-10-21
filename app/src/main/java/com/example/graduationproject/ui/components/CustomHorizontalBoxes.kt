package com.example.graduationproject.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.graduationproject.R

@Composable
fun CustomHorizontalBoxes() {

    val specials = listOf(
        "Yemek" to R.drawable.hamburger_image,
        "Hızlı Market" to R.drawable.vegetables_image,
        "Dolap" to R.drawable.surprise_image,
        "Sanat Eserleri" to R.drawable.trendyol_art_image,
        "Eskiyi Getir Yeniyi Götür" to R.drawable.phone_image,
        "Ayrıcalıkları Keşfet" to R.drawable.trendyol_plus_image,
        "Kuponlar" to R.drawable.coupon_image
    )
    val specialList = remember { mutableStateOf(specials) }

    LazyRow(
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        items(
            count = specialList.value.size
        ) {
            val example = specialList.value[it]
            Column(
                modifier = Modifier
                    .width(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(color = colorResource(id = R.color.black))
                        .border(width = 2.dp, color = colorResource(id = R.color.orange), shape = RoundedCornerShape(32.dp))
                ) {
                    Image(
                        painter = painterResource(id = example.second),
                        contentDescription = example.first,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    text = example.first,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize(),
                    color = colorResource(id = R.color.black),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
        }
    }
}