package com.example.graduationproject.ui.components

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
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Categories

@Composable
fun CustomLazyRowGrid() {


    fun getCategories() : List<Categories> {

        return listOf(
            Categories(1,"Pantolonlar", image = R.drawable.pant_image),
            Categories(1,"Kazaklar", image = R.drawable.sweatshirt_image),
            Categories(1,"Ceketler", image = R.drawable.jacket_image),
            Categories(1,"Ayakkabılar", image = R.drawable.nike_shoes_image),
            Categories(1,"Ev Aletleri", image = R.drawable.kettle_image),
            Categories(1,"Bluzlar", image = R.drawable.blouze_image),
            Categories(1,"Bilgisayalar", image = R.drawable.mackbook_image),
            Categories(1,"Telefonlar", image = R.drawable.single_phone_image),
            Categories(1,"Kahve Makineleri", image = R.drawable.tea_machine_image),
            Categories(1,"Süveterler", image = R.drawable.jumper_image),
        )
    }

    val categoriesList = remember { mutableStateOf(getCategories()) }


    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier
            .height(360.dp)
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.Top
    ) {
        items(
            count = categoriesList.value.size
        ) {
            val category = categoriesList.value[it]
            Column(
                modifier = Modifier
                    .size(85.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    if(category.image != null) {
                        Image(
                            painter = painterResource(id = category.image),
                            contentDescription = category.name,
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(12.dp))
                                .size(75.dp)
                        )
                    }
                Text(
                    text = category.name,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}