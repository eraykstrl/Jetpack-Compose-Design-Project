package com.example.graduationproject.ui.components

import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Product

@Composable
fun CustomProductVertical() {

    fun getAllList() : List<Product> {
        return listOf(Product(1, "Zara", R.drawable.blouze_image, "Bluz", "500"),
            Product(
                2,
                "Jack Jones",
                R.drawable.coat_image,
                "Kışlık Mont",
                "5000"
            ),
            Product(
                3,
                "Levis",
                R.drawable.pant_image,
                "Regular Fit Kot Pantolon",
                "1500"
            ),
            Product(
                4,
                "Tudors",
                R.drawable.tshirt_image,
                "Beyaz Tişört",
                "399"
            ),
            Product(
                5,
                "Zara",
                R.drawable.jumper_image,
                "Süveter Kazak",
                "1200"
            ),
            Product(
                6,
                "Avva",
                R.drawable.jacket_image,
                "Yazlık Ceket",
                "1500"
            ),
            Product(
                7,
                "Defacto",
                R.drawable.sweatshirt_image,
                "Kapşonlu Sweatshirt",
                "600"
            ),
            Product(8, "Nike", R.drawable.nike_shoes_image, "Nike Ayakkabı", "2000"),
            Product(
                9,
                "Samsung",
                R.drawable.single_phone_image,
                "Galaxy S25 Telefon",
                "60000"
            ),
            Product(
                10,
                "Mackbook",
                R.drawable.mackbook_image,
                "Mackbook Pro M4 Çip",
                "82999"
            ),
            Product(
                11,
                "Kiwi",
                R.drawable.tea_machine_image,
                "Çay Makinesi",
                "989"
            ),
            Product(
                12,
                "Mario",
                R.drawable.kettle_image,
                "Cam Kettle",
                "600"
            ),
            Product(
                13,
                "Jack Jones",
                R.drawable.coat_image,
                "Kışlık Mont",
                "5000"
            ),
            Product(
                14,
                "Levis",
                R.drawable.pant_image,
                "Regular Fit Kot Pantolon",
                "1500"
            ),
            Product(
                15,
                "Tudors",
                R.drawable.tshirt_image,
                "Beyaz Tişört",
                "399"
            ),
            Product(
                16,
                "Zara",
                R.drawable.jumper_image,
                "Süveter Kazak",
                "1200"
            ),
            Product(
                17,
                "Avva",
                R.drawable.jacket_image,
                "Yazlık Ceket",
                "1500"
            )

        )
    }

    val gridList = remember { mutableStateOf(getAllList()) }

    val heightX = ((gridList.value.size + 2) / 2) * 310

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .height(heightX.dp)
            .padding(horizontal = 8.dp)
        ,
        horizontalArrangement = Arrangement.SpaceEvenly,
        userScrollEnabled = false,

    ) {
        items(gridList.value.size) { index ->
            val product = gridList.value[index]
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = colorResource(id = R.color.white))
                    .padding(horizontal = 4.dp, vertical = 4.dp)
                    .size(width = 200.dp, height = 300.dp)
                    .border(width = 2.dp, color = colorResource(id = R.color.gray))
                ,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = product.name,
                    modifier = Modifier
                        .size(150.dp, 200.dp)
                        .padding(top = 8.dp)
                    ,
                    alignment = Alignment.Center
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(product.brand)
                        }
                        append(" ")
                        append(product.name)
                    },
                    color = colorResource(id = R.color.black),
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
                Text(
                    text = "${product.price} TL",
                    color = colorResource(id = R.color.orange),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }

}