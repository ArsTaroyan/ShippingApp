package com.example.shipping.presentation.menuscreen

import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
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
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
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
fun LogoImage() {
    GlideImage(
        model = "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
        contentDescription = "loadImage",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(70.dp, 70.dp)
    ) {
        it.error(R.drawable.ic_launcher_foreground)
            .placeholder(R.drawable.ic_launcher_background)
            .load("https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704")
    }
}

@Composable
fun InitLazyRow(
    navController: NavHostController
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(
            listOf(
                Product(1, "Colla", "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "asdfdasdfasdf", 1, 1),
                Product(2, "Colla", "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "asdgfasdgff", 2, 1),
                Product(3, "Colla", "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "dasfasdf", 3, 1),
                Product(4, "Colla", "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "sdfgdfsgrtesshg", 4, 1),
                Product(5, "Colla", "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "sdfgdfgdssdfg.sdfg", 5, 1),
                Product(6, "Colla", "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "sdfgdrts", 6, 1),
                Product(7, "Colla", "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "xzsc", 7, 1),
                Product(8, "Colla", "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "esrytghdsg", 8, 1)
            )
        ){_, item ->
            ItemProductRow(navController = navController, item = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController())
}