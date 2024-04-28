package com.example.shipping.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shipping.data.preferences.Preference
import com.example.shipping.domain.utils.Screen
import com.example.shipping.presentation.comeinscreen.ComeInScreen
import com.example.shipping.presentation.menuscreen.MenuScreen
import com.example.shipping.presentation.ordersscreen.OrdersScreen
import com.example.shipping.presentation.shippingscreen.ShippingScreen
import com.example.shipping.presentation.splashscreen.SplashScreen

@Composable
fun NavGraph(navController: NavHostController, preference: Preference?) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(
            route = Screen.ComeIn.route
        ) {
            ComeInScreen(navController, preference)
        }

        composable(
            route = Screen.Menu.route
        ) {
            MenuScreen(navController)
        }

        composable(
            route = Screen.Splash.route
        ) {
            SplashScreen(navController, preference)
        }

        composable(
            route = Screen.Orders.route
        ) {
            OrdersScreen(navController)
        }

        composable(
            route = Screen.Shipping.route
        ) {
            ShippingScreen(navController)
        }
    }
}