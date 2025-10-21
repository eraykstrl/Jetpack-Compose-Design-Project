package com.example.graduationproject.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Product
import com.example.graduationproject.ui.components.CustomHorizontalBanner
import com.example.graduationproject.ui.components.CustomHorizontalBoxes
import com.example.graduationproject.ui.components.CustomLazyRowGrid
import com.example.graduationproject.ui.components.CustomOpportunitiesProducts
import com.example.graduationproject.ui.components.CustomOutlinedTextField
import com.example.graduationproject.ui.components.CustomProductBox
import com.example.graduationproject.ui.components.CustomProductVertical
import com.example.graduationproject.ui.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    fun loadAllProductFirst() : List<Product>  {
        return listOf(Product(1, "Nike", R.drawable.nike_shoes_image, "Nike Ayakkabı", "2000"),
            Product(
                2,
                "Samsung",
                R.drawable.single_phone_image,
                "Galaxy S25 Telefon",
                "60000"
            ),
            Product(
                3,
                "Mackbook",
                R.drawable.mackbook_image,
                "Mackbook Pro M4 Çip",
                "82999"
            ),
            Product(
                4,
                "Kiwi",
                R.drawable.tea_machine_image,
                "Çay Makinesi",
                "989"
            ),
            Product(
                5,
                "Mario",
                R.drawable.kettle_image,
                "Cam Kettle",
                "600"
            ),
            Product(
                6,
                "Jack Jones",
                R.drawable.coat_image,
                "Kışlık Mont",
                "5000"
            ),
            Product(
                7,
                "Levis",
                R.drawable.pant_image,
                "Regular Fit Kot Pantolon",
                "1500"
            ),
            Product(
                8,
                "Tudors",
                R.drawable.tshirt_image,
                "Beyaz Tişört",
                "399"
            ),
            Product(
                9,
                "Zara",
                R.drawable.jumper_image,
                "Süveter Kazak",
                "1200"
            ),
            Product(
                10,
                "Avva",
                R.drawable.jacket_image,
                "Yazlık Ceket",
                "1500"
            )
        )
    }

    fun flashProducts() : List<Product>  {
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
            )

        )
    }

    val firstList = remember { mutableStateOf(loadAllProductFirst()) }
    val flashList = remember { mutableStateOf(flashProducts()) }

    Scaffold(
        topBar = {
            CustomTopAppBar()
            CustomOutlinedTextField()
        }
    )
     {
        paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                item {

                    CustomHorizontalBanner()
                    CustomHorizontalBoxes()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .padding(top = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Sana Özel Ürünler",
                            color = colorResource(id = R.color.dark_gray),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Row {
                            Text(
                                text = "Tümünü Gör",
                                color = colorResource(id = R.color.orange),
                                fontSize = 16.sp
                            )

                            Icon(
                                painterResource(id = R.drawable.arrow_forward),
                                contentDescription = "See All",
                                tint = colorResource(id = R.color.orange)
                            )
                        }
                    }

                    CustomProductBox(
                        colorList = listOf(R.color.white, R.color.white), firstList
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = colorResource(id = R.color.orange)
                                )
                                .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Flaş Ürünler",
                                color = colorResource(id = R.color.white),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Row {
                                Text(
                                    text = "Tümünü Gör",
                                    color = colorResource(id = R.color.white)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Icon(
                                    painterResource(id = R.drawable.arrow_forward),
                                    contentDescription = "See All",
                                    tint = colorResource(id = R.color.white)
                                )
                            }
                        }

                        Log.e("MainScreen", "${firstList.value}")


                        CustomProductBox(
                            colorList = listOf(R.color.orange, R.color.dark_gray),
                            flashList
                        )
                        CustomOpportunitiesProducts(
                            listOf(R.color.black, R.color.purple_700),
                            "DEFACTO",
                            60,
                            "ERKEN KIŞ ALIŞVERİŞİ",
                            R.drawable.model_image
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                            ,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = stringResource(id =R.string.popular_week_product),
                                color = colorResource(id = R.color.black),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Row {
                                Text(
                                    text = stringResource(id =R.string.see_all_text),
                                    color = colorResource(id = R.color.orange),
                                    fontSize = 16.sp

                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_forward),
                                    contentDescription =stringResource(id = R.string.see_all_text),
                                    tint = colorResource(id = R.color.orange)
                                )
                            }
                        }
                    }

                    CustomProductVertical()
                    Text(
                        text = stringResource(id = R.string.custom_category_you),
                        modifier = Modifier
                            .padding(start = 8.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
                    )
                    CustomLazyRowGrid()
                }

            }

        }

    }

}