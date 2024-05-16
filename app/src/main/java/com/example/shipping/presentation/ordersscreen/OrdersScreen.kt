package com.example.shipping.presentation.ordersscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shipping.domain.module.Order
import com.example.shipping.domain.module.Product
import com.example.shipping.presentation.menuscreen.LogoImage

@Composable
fun OrdersScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OrdersColumn(navController = navController)
    }
}

@Composable
fun OrdersColumn(navController: NavHostController) {
    LogoImage()
    InitOrdersLazyRow(navController)
}

@Composable
fun InitOrdersLazyRow(navController: NavHostController) {
    var items by remember {
        mutableStateOf(listOf<Order>())
    }

    items = listOf(
        Order(
            1,
            "1/1/1",
            140,
            "Shipping",
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
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(items) { _, item ->
            ItemOrdersRow(item = item, navController = navController)
        }

    }
}
