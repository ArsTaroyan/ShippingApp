package com.example.shipping.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.shipping.domain.data.preferences.Preference
import com.example.shipping.domain.utils.Screen
import com.example.shipping.presentation.ComeInScreen
import com.example.shipping.presentation.MenuScreen
import com.example.shipping.presentation.SplashScreen

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
            MenuScreen(navController, preference)
        }

        composable(
            route = Screen.Splash.route
        ) {
            SplashScreen(navController, preference)
        }
    }
}