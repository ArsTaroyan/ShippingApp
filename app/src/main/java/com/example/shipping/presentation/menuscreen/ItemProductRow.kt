package com.example.shipping.presentation.menuscreen

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shipping.R
import com.example.shipping.domain.module.Product
import com.example.shipping.domain.utils.Screen
import com.example.shipping.extension.convertGsonToString
import com.example.shipping.extension.gradientButton
import com.example.shipping.presentation.shippingscreen.ShippingViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun ItemProductRow(
    navController: NavHostController,
    item: Product
) {
    Column(
        modifier = Modifier
            .width(185.dp)
            .padding(top = 30.dp)
            .clickable {
                navController.navigate(
                    route = Screen.Details.detailsProduct(
                        item.convertGsonToString()
                    )
                )
            }
    ) {
        BindData(item)
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BindData(
    data: Product,
    viewModel: ShippingViewModel = hiltViewModel()
) {
    var count by remember {
        mutableIntStateOf(1)
    }

    var isCopy by remember {
        mutableStateOf(false)
    }

    viewModel.getProduct(data.product_id)
    viewModel.getAllProducts()

    val product by viewModel.getProduct.collectAsState(initial = null)

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        GlideImage(
            model = data.product_img,
            contentDescription = "loadImage",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 90.dp, height = 100.dp)
        ) {
            it.error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .load(data.product_img)
        }
    }

    Text(
        text = data.product_name,
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(top = 10.dp)
    )

    Text(
        text = "${data.product_price * count}$",
        fontSize = 12.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(top = 7.dp),
    )

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.8f)
                .padding(end = 20.dp)
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
                            --count
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
                        ++count
                    }
            )
        }

        IconButton(
            modifier = Modifier
                .padding(end = 10.dp)
                .background(
                    Brush.gradientButton(),
                    RoundedCornerShape(5.dp)
                ),
            onClick =  {
                    count = if (!isCopy) {
                        viewModel.addProduct(data.copy(product_count = count))
                        1
                    } else {
                        viewModel.updateProduct(data.copy(product_count = count))
                        1
                    }
                }
        ) {
            Icon(
                painter = painterResource(R.drawable.add_to_cart),
                contentDescription = null,
                tint = Color.White
            )
        }
    }

    rememberCoroutineScope().launch {
        viewModel.getAllProducts.first().collectLatest {
            isCopy = it.contains(product)
        }
    }
}