package com.example.shipping.nav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.shipping.data.preferences.Preference
import com.example.shipping.domain.utils.DETAILS_PRODUCT
import com.example.shipping.domain.utils.Screen
import com.example.shipping.extension.convertStringToGson
import com.example.shipping.presentation.comeinscreen.ComeInScreen
import com.example.shipping.presentation.detailsscreen.DetailsScreen
import com.example.shipping.presentation.menuscreen.MenuScreen
import com.example.shipping.presentation.ordersscreen.OrdersScreen
import com.example.shipping.presentation.shippingscreen.ShippingScreen
import com.example.shipping.presentation.splashscreen.SplashScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun NavGraph(
    navController: NavHostController,
    preference: Preference?
) {
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

        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(name = DETAILS_PRODUCT) {
                    type = NavType.StringType
                }
            )
        ) {index ->
            index.arguments?.getString(DETAILS_PRODUCT)
                ?.let { DetailsScreen(navController, it.convertStringToGson()) }
        }
    }
}