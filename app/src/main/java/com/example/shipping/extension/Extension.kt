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
import com.example.shipping.domain.utils.ORDERS_PRODUCT
import com.example.shipping.domain.utils.Screen
import com.example.shipping.presentation.comeinscreen.ComeInScreen
import com.example.shipping.presentation.detailsorderscreen.DetailsOrderScreen
import com.example.shipping.presentation.detailspoductscreen.DetailsProductScreen
import com.example.shipping.presentation.splashscreen.SplashScreen
import com.example.shipping.ui.theme.selectEndButton
import com.example.shipping.ui.theme.selectStartButton
import com.example.shipping.ui.theme.unselectEndButton
import com.example.shipping.ui.theme.unselectStartButton
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

fun NavGraphBuilder.detailsProductNavGraph(
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
                ?.let {
                    DetailsProductScreen(
                        product = it.convertStringToGson(),
                        navController = navController
                    )
                }
        }
    }
}

fun NavGraphBuilder.detailsOrderNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Splash.route,
        route = ORDERS_PRODUCT
    ) {
        composable(
            route = Screen.Orders.route,
            arguments = listOf(
                navArgument(name = ORDERS_PRODUCT) {
                    type = NavType.StringType
                }
            )
        ) { index ->
            index.arguments?.getString(ORDERS_PRODUCT)
                ?.let {
                    DetailsOrderScreen(
                        order = it.convertStringToGson(),
                        navController = navController
                    )
                }
        }
    }
}

fun Brush.Companion.gradientButton(): Brush =
    verticalGradient(
        colors = listOf(
            selectStartButton,
            selectEndButton
        )
    )

fun Brush.Companion.whiteButton(): Brush =
    verticalGradient(
        colors = listOf(
            unselectStartButton,
            unselectEndButton
        )
    )
