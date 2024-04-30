package com.example.shipping.presentation.shippingscreen

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shipping.R
import com.example.shipping.domain.module.Product

@Composable
fun ItemProductColumn(item: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(1.dp, Color.Black)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BindData(item)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BindData(
    data: Product,
    viewModel: ShippingViewModel = hiltViewModel()
) {
    var count by remember {
        mutableIntStateOf(0)
    }

    count = data.product_count

    Box(
        modifier = Modifier
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        GlideImage(
            model = data.product_img,
            contentDescription = "loadImage",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 80.dp, height = 90.dp)
        ) {
            it.error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .load(data.product_img)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(end = 10.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = data.product_description,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth(0.5f)
        )

        Text(
            text = "${data.product_price * count}$",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 15.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, Color.Black)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_remove),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        if (count > 1) {
                            viewModel.updateProduct(product = data.copy(product_count = --count))
                        }
                    }
            )

            Text(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                text = "$count",
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        viewModel.updateProduct(product = data.copy(product_count = ++count))
                    }
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                viewModel.removeProduct(data)
            },
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
        ) {
            Text(text = "Delete to Card", color = Color.White, fontSize = 12.sp)
        }
    }

}