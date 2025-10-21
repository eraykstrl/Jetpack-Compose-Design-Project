package com.example.graduationproject.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.graduationproject.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CustomHorizontalBanner() {

    val images = listOf(
        R.drawable.phone_image,
        R.drawable.hamburger_photo
    )

    val horizontalPager = rememberPagerState(pageCount = {images.size})
    val scope = rememberCoroutineScope()
    val sizeOfList = remember { mutableStateOf(images.size.toString()) }
    val pageNumber = remember { mutableStateOf("1") }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val nextPage = (horizontalPager.currentPage + 1) % images.size
            scope.launch {
                horizontalPager.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = FastOutSlowInEasing
                    )
                    )
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = 8.dp, vertical = 8.dp)
    )
    {
        HorizontalPager(
            state = horizontalPager,
            modifier = Modifier
                .fillMaxSize()
        ) {
            page ->
            pageNumber.value = (page+1).toString()
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = stringResource(
                    id = R.string.popular_box
                ),
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .background(color = colorResource(id = R.color.black))
                .align(Alignment.BottomEnd)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = "${pageNumber.value}/${sizeOfList.value}",
                modifier = Modifier
                    .padding(2.dp),
                color = colorResource(id = R.color.white)
            )
        }
    }
}