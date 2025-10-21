package com.example.graduationproject.ui.components

import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graduationproject.R

@Composable
fun CustomOpportunitiesProducts(@ColorRes colorList : List<Int>,brand : String,discount: Int,textRes : String,image : Int) {
    val discountCopy = remember { mutableStateOf(discount) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .background(brush = Brush.horizontalGradient(
                colors = listOf(colorResource(id= R.color.orange),colorResource(id = R.color.white))
            ))

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 8.dp)
                    .width(100.dp)
            ) {
                Text(
                    text = textRes,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        brush = Brush.verticalGradient(
                            colors = colorList.map { colorResource(id = it) },
                        ),
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(
                    id = R.string.winter_opportunities
                ),
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(top = 16.dp)
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 8.dp)
                    .width(150.dp)
            ) {
                Text(
                    text = "%${discountCopy.value} " + stringResource(
                        id = R.string.discount_text
                    ),
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        brush = Brush.verticalGradient(
                            colors = colorList.map { colorResource(id = it) },
                        ),
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = brand,
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(all = 16.dp)
        )

    }
}