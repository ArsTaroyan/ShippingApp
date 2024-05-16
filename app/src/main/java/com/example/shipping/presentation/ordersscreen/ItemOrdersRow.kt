package com.example.shipping.presentation.ordersscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shipping.R
import com.example.shipping.domain.module.Order
import com.example.shipping.extension.gradientButton


@Composable
fun ItemOrdersRow(
    navController: NavHostController,
    item: Order
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 5.dp, start = 15.dp, end = 15.dp)
            .height(150.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
            .padding(horizontal = 20.dp, vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BindData(item, navController)
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BindData(
    data: Order,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Text(
                text = "Date:",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = data.date,
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 7.dp),
            )
        }
        Row {
            Text(
                text = "Date Number:",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "${data.id}",
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 7.dp),
            )
        }
        Row {
            Text(
                text = "Total:",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "${data.total}$",
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 7.dp),
            )
        }
        Row {
            Text(
                text = "Status:",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = data.status,
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 7.dp),
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Button(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .background(
                    Brush.gradientButton(),
                    RoundedCornerShape(5.dp),
                ),
            onClick = {
                /*View Details*/
            },
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(text = "View Details", color = Color.White, fontSize = 12.sp)
        }
        Button(
            modifier = Modifier
                .background(
                    Brush.gradientButton(),
                    RoundedCornerShape(5.dp),
                ),
            onClick = {
                /*Repeat Order*/
            },
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(text = "Repeat Order", color = Color.White, fontSize = 12.sp)
        }
    }
}