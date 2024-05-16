package com.example.shipping.presentation.detailsorderscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shipping.domain.module.Order
import com.example.shipping.domain.module.Product
import com.example.shipping.presentation.menuscreen.LogoImage

@Composable
fun DetailsOrderScreen(
    order: Order,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 70.dp)
    ) {
        LogoImage(isBack = true, navController = navController)
        OrderLazyColumn(order.products)
    }
}

@Composable
fun OrderLazyColumn(
    products: List<Product>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(products) { _, item ->
            ItemDetails(item = item)
        }
    }
}
