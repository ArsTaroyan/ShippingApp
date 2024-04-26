package com.example.shipping.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shipping.domain.utils.Screen
import com.example.shipping.presentation.ComeInScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ComeIn.route
    ) {
        composable(
            route = Screen.ComeIn.route
        ) {
            ComeInScreen(navController)
        }
    }
}