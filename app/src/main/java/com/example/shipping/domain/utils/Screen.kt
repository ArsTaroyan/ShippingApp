package com.example.shipping.domain.utils

const val DETAILS_PRODUCT = "product"
const val AUTHENTICATION_ROUTE = "authentication"
const val HOME_ROUTE = "home"
const val ROOT_ROUTER = "root"

sealed class Screen(val route: String) {
    object ComeIn : Screen(route = "come_in_screen")
    object Splash : Screen(route = "splash_screen")
    object Details : Screen(route = "details_screen?product={$DETAILS_PRODUCT}") {
        fun detailsProduct(
            product: String
        ): String {
            return "details_screen?product=$product"
        }
    }
}