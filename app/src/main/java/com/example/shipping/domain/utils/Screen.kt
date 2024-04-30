package com.example.shipping.domain.utils

const val DETAILS_PRODUCT = "product"
sealed class Screen(val route: String) {
    object ComeIn: Screen(route = "come_in_screen")
    object Menu: Screen(route = "menu_screen")
    object Splash: Screen(route = "splash_screen")
    object Orders: Screen(route = "orders_screen")
    object Shipping: Screen(route = "shipping_screen")
    object Details: Screen(route = "details_screen?product={$DETAILS_PRODUCT}") {
        fun detailsProduct(
            product: String
        ): String {
            return "details_screen?product=$product"
        }
    }
}