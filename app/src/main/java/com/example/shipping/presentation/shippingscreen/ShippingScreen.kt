package com.example.shipping.presentation.shippingscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shipping.domain.module.Product
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
@Composable
fun ShippingScreen(
    navController: NavHostController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        InitLazyColumn(navController)
    }

}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun InitLazyColumn(
    navController: NavHostController,
    viewModel: ShippingViewModel = hiltViewModel()
) {
    var items by remember {
        mutableStateOf(listOf<Product>())
    }
    viewModel.getAllProducts()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items) { _, item ->
            ItemProductColumn(item = item)
        }

    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .padding(horizontal = 15.dp),
            onClick = {
                navController.popBackStack()
            },
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
        ) {
            Text(text = "Back", color = Color.White, fontSize = 15.sp)
        }

        Button(
            onClick = {
                viewModel.removeAllProducts()
                navController.popBackStack()
            },
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
        ) {
            Text(text = "RemoveAll", color = Color.White, fontSize = 15.sp)
        }

        Button(
            modifier = Modifier
                .padding(horizontal = 15.dp),
            onClick = {
                /*Shipping*/
            },
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
        ) {
            Text(text = "Shipping", color = Color.White, fontSize = 15.sp)
        }
    }

    rememberCoroutineScope().launch {
        viewModel.getAllProducts.first().collectLatest {
            items = it
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShippingScreenPreview() {
    ShippingScreen(navController = rememberNavController())
}