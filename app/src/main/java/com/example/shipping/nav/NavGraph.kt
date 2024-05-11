package com.example.shipping.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shipping.data.preferences.Preference
import com.example.shipping.domain.utils.AUTHENTICATION_ROUTE
import com.example.shipping.domain.utils.HOME_ROUTE
import com.example.shipping.domain.utils.ROOT_ROUTER
import com.example.shipping.extension.authNavGraph
import com.example.shipping.presentation.homescreen.HomeScreen


@Composable
fun NavGraph(
    preference: Preference?
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AUTHENTICATION_ROUTE,
        route = ROOT_ROUTER
    ) {
        authNavGraph(navController, preference)

        composable(
            route = HOME_ROUTE,
        ) {
            HomeScreen()
        }
    }
}