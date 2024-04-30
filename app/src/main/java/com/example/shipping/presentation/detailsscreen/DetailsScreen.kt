package com.example.shipping.presentation.detailsscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shipping.R
import com.example.shipping.domain.module.Product

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DetailsScreen(
    navController: NavHostController,
    product: Product
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        BindData(product, navController)
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BindData(
    data: Product,
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.4f)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        GlideImage(
            model = data.product_img,
            contentDescription = "loadImage",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 150.dp, height = 160.dp)
        ) {
            it.error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .load(data.product_img)
        }
    }

    Text(
        text = data.product_description,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 20.dp)
    )

    Text(
        text = "${data.product_price}$",
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(top = 20.dp),
    )

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        onClick = {
            navController.popBackStack()
        },
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
    ) {
        Text(text = "Back", color = Color.White, fontSize = 18.sp)
    }
}