package com.example.shipping.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shipping.nav.NavGraph
import com.example.shipping.ui.theme.ShippingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShippingTheme {
                InitNavController()
            }
        }
    }
}

@Composable
private fun InitNavController() {
    val navController: NavHostController = rememberNavController()
    NavGraph(navController = navController)
}