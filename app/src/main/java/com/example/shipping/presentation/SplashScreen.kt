package com.example.shipping.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shipping.domain.data.preferences.Preference
import com.example.shipping.domain.utils.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navController: NavHostController,
    preference: Preference?
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Loading...", fontSize = 40.sp, fontWeight = FontWeight.Bold)
    }
    AutoComeIn(navController, preference)
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun AutoComeIn(navController: NavHostController, preference: Preference?) {
    rememberCoroutineScope().launch {
        delay(2000)
        if (!preference?.readCode(Preference.COMEINCODE).isNullOrEmpty()) {
            navController.navigate(route = Screen.Menu.route) {
                popUpTo(route = Screen.Splash.route) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(route = Screen.ComeIn.route) {
                popUpTo(route = Screen.Splash.route) {
                    inclusive = true
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController(), preference = null)
}