package com.example.shipping.presentation.shippingscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shipping.R
import com.example.shipping.domain.module.Product

@Composable
fun ItemProductRow(item: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 5.dp, start = 15.dp, end = 15.dp)
            .height(150.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
            .padding(10.dp),
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
                .size(width = 100.dp, height = 110.dp)
        ) {
            it.error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .load(data.product_img)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

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
            text = "${data.product_price * count}$",
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .border(width = 1.dp, Color.Black, shape = RoundedCornerShape(5.dp))
                .padding(12.dp)
                .background(color = Color.Transparent),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_remove),
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
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 15.sp
            )
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        viewModel.updateProduct(product = data.copy(product_count = ++count))
                    }
            )
        }
    }

    IconButton(
        onClick = {
            viewModel.removeProduct(data)
        }
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxSize(),
            imageVector = Icons.Default.Clear,
            contentDescription = null,
        )
    }
}

