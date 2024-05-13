package com.example.shipping.extension

import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.shipping.data.preferences.Preference
import com.example.shipping.domain.utils.AUTHENTICATION_ROUTE
import com.example.shipping.domain.utils.DETAILS_PRODUCT
import com.example.shipping.domain.utils.Screen
import com.example.shipping.presentation.comeinscreen.ComeInScreen
import com.example.shipping.presentation.detailsscreen.DetailsScreen
import com.example.shipping.presentation.splashscreen.SplashScreen
import com.example.shipping.ui.theme.endButton
import com.example.shipping.ui.theme.midButton
import com.example.shipping.ui.theme.startButton
import com.google.gson.Gson

fun <T> T.convertGsonToString(): String = Gson().toJson(this)

inline fun <reified T> String.convertStringToGson(): T = Gson().fromJson(this, T::class.java)

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    preference: Preference?
) {
    navigation(
        startDestination = Screen.Splash.route,
        route = AUTHENTICATION_ROUTE
    ) {
        composable(
            route = Screen.Splash.route
        ) {
            SplashScreen(navController, preference)
        }

        composable(
            route = Screen.ComeIn.route
        ) {
            ComeInScreen(navController, preference)
        }
    }
}

fun NavGraphBuilder.detailsNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Splash.route,
        route = DETAILS_PRODUCT
    ) {
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(name = DETAILS_PRODUCT) {
                    type = NavType.StringType
                }
            )
        ) { index ->
            index.arguments?.getString(DETAILS_PRODUCT)
                ?.let { DetailsScreen(navController, it.convertStringToGson()) }
        }
    }
}

fun Brush.Companion.gradientButton(): Brush =
    verticalGradient(
        colors = listOf(
            startButton,
            midButton,
            endButton
        )
    )
