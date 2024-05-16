package com.example.shipping.presentation.shippingscreen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shipping.domain.module.Product
import com.example.shipping.extension.gradientButton
import com.example.shipping.presentation.menuscreen.LogoImage
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun ShippingScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LogoImage()
        InitLazyColumn()
    }

}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun InitLazyColumn(
    viewModel: ShippingViewModel = hiltViewModel()
) {
    var items by remember {
        mutableStateOf(listOf<Product>())
    }
    var isVisible by remember {
        mutableStateOf(true)
    }
    viewModel.getAllProducts()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            itemsIndexed(items) { _, item ->
                ItemProductRow(item = item)
            }

        }
        AnimatedVisibility(
            visible = isVisible
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 7.dp, end = 15.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End,
            ) {
                Button(
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .background(
                            Brush.gradientButton(),
                            RoundedCornerShape(5.dp),
                        ),
                    onClick = {
                        isVisible = false
                    },
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(text = "Gone", color = Color.White, fontSize = 12.sp)
                }
                Button(
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .background(
                            Brush.gradientButton(),
                            RoundedCornerShape(5.dp),
                        ),
                    onClick = {
                        /*Shipping*/
                    },
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(text = "Shipping", color = Color.White, fontSize = 12.sp)
                }
                Button(
                    modifier = Modifier
                        .background(
                            Brush.gradientButton(),
                            RoundedCornerShape(5.dp),
                        ),
                    onClick = {
                        viewModel.removeAllProducts()
                    },
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(text = "RemoveAll", color = Color.White, fontSize = 12.sp)
                }
            }
        }
        AnimatedVisibility(
            visible = !isVisible
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 7.dp, start = 15.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start,
            ) {
                Button(
                    modifier = Modifier
                        .background(
                            Brush.gradientButton(),
                            RoundedCornerShape(5.dp),
                        ),
                    onClick = {
                        isVisible = true
                    },
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(text = "Visible", color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }

    rememberCoroutineScope().launch {
        viewModel.getAllProducts.first().collectLatest {
            items = it
        }
    }
}