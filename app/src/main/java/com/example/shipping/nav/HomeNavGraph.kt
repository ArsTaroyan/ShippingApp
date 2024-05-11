package com.example.shipping.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shipping.domain.utils.BottomNavigationScreen
import com.example.shipping.domain.utils.HOME_ROUTE
import com.example.shipping.extension.detailsNavGraph
import com.example.shipping.presentation.menuscreen.MenuScreen
import com.example.shipping.presentation.ordersscreen.OrdersScreen
import com.example.shipping.presentation.shippingscreen.ShippingScreen

@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreen.Menu.route,
        route = HOME_ROUTE
    ) {
        composable(
            route = BottomNavigationScreen.Menu.route
        ) {
            MenuScreen(navController)
        }

        composable(
            route = BottomNavigationScreen.Orders.route
        ) {
            OrdersScreen(navController)
        }

        composable(
            route = BottomNavigationScreen.Shipping.route
        ) {
            ShippingScreen(navController)
        }

        detailsNavGraph(navController)
    }
}