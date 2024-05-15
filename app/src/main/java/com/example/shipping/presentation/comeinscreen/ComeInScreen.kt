package com.example.shipping.presentation.comeinscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shipping.R
import com.example.shipping.data.preferences.Preference
import com.example.shipping.data.preferences.Preference.Companion.COMEINCODE
import com.example.shipping.domain.utils.HOME_ROUTE
import com.example.shipping.domain.utils.Screen
import com.example.shipping.extension.gradientButton
import kotlinx.coroutines.launch


@Composable
fun ComeInScreen(
    navController: NavHostController,
    preference: Preference?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComeInColum(navController, preference)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ComeInColum(navController: NavHostController, preference: Preference?) {
    var textState by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    GlideImage(
        model = "https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704",
        contentDescription = "loadImage",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp, 80.dp)
    ) {
        it.error(R.drawable.ic_launcher_foreground)
            .placeholder(R.drawable.ic_launcher_background)
            .load("https://www.gunz.cc/Product-image/Coca-Cola-033l-Image-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704")
    }

    Column(
        Modifier.padding(bottom = 60.dp)
    ) {
        val text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 50.sp
                )
            ) {
                append("Hello,\n\n")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 50.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                )
            ) {
                append("welcome!")
            }
        }

        Text(text = text)

        Spacer(Modifier.padding(top = 20.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp)),
            value = textState,
            onValueChange = {
                if (it.length <= 5) textState = it
            },
            placeholder = {
                Text(text = "Input your code")
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Black,
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )
        )
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(
                Brush.gradientButton(),
                RoundedCornerShape(10.dp),
            ),
        onClick = {
            scope.launch {
                if (textState == "11111") {
                    preference?.saveCode(COMEINCODE, textState)
                    navController.navigate(HOME_ROUTE) {
                        popUpTo(Screen.ComeIn.route) {
                            inclusive = true
                        }
                    }
                }
            }
        },
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = "Login",
            color = Color.White,
            fontSize = 25.sp
        )
    }
}
