package com.example.shipping.presentation.detailsorderscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shipping.R
import com.example.shipping.domain.module.Product

@Composable
fun ItemDetails(
    item: Product
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 5.dp, start = 15.dp, end = 15.dp)
            .height(100.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OrderData(item)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun OrderData(
    data: Product
) {
    Row(
        modifier = Modifier
            .fillMaxHeight(),
    ) {
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
                    .size(width = 70.dp, height = 80.dp)
            ) {
                it.error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_background)
                    .load(data.product_img)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Text(
                    text = data.product_name,
                    fontSize = 12.sp,
                    maxLines = 2,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                )

                Text(
                    text = "${data.product_price}$",
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Row {
                Text(
                    text = "Quantity:",
                    fontSize = 10.sp,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "${data.product_count}",
                    fontSize = 10.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 7.dp),
                )
            }
        }
    }
}