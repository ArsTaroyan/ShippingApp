package com.example.shipping.presentation.menuscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shipping.R
import com.example.shipping.domain.module.Product


@Composable
fun MenuScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuColumn(navController = navController)
    }
}

@Composable
fun MenuColumn(navController: NavHostController) {
    LogoImage()
    InitLazyRow(navController)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LogoImage(
    isBack: Boolean = false,
    navController: NavHostController = rememberNavController()
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = if (isBack) Arrangement.SpaceBetween else Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(visible = isBack) {
                IconButton(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        painter = painterResource(R.drawable.back_button),
                        contentDescription = null,
                    )
                }
            }
            GlideImage(
                model = "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                contentDescription = "loadImage",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp, 60.dp)
                    .padding(top = 8.dp, bottom = 8.dp, end = 15.dp)
            ) {
                it.error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_background)
                    .load("https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704")
            }
        }
    }
}

@Composable
fun InitLazyRow(
    navController: NavHostController
) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        columns = StaggeredGridCells.Fixed(2)
    ) {
        itemsIndexed(
            listOf(
                Product(
                    1,
                    "Colla",
                    "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                    "asdfsdafsadkfljhalsdfkasdfkklasdgfdgjkhasdggfkasdjhgfasdkjhfgasddkjfhgaksjdhfgaksjdhfaksjdhfbgbasdkjdhfbgbgaskjhfdbgdasdkjhfbvvjashkdvbfhjasdgbfvjkhgcbsdayukfjkhasdbfvcukdasdfasdf",
                    1,
                    1
                ),
                Product(
                    2,
                    "Colla",
                    "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                    "asdgfasdgff",
                    2,
                    1
                ),
                Product(
                    3,
                    "Colla",
                    "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                    "dasfasdf",
                    3,
                    1
                ),
                Product(
                    4,
                    "Colla",
                    "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                    "sdfgdfsgrtesshg",
                    4,
                    1
                ),
                Product(
                    5,
                    "Colla",
                    "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                    "sdfgdfgdssdfg.sdfg",
                    5,
                    1
                ),
                Product(
                    6,
                    "Colla",
                    "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                    "sdfgdrts",
                    6,
                    1
                ),
                Product(
                    7,
                    "Colla",
                    "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                    "xzsc",
                    7,
                    1
                ),
                Product(
                    8,
                    "Colla",
                    "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
                    "esrytghdsg",
                    8,
                    1
                )
            )
        ) { _, item ->
            ItemProductRow(navController = navController, item = item)
        }
    }
}