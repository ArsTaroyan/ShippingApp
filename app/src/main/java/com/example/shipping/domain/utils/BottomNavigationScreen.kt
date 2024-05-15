package com.example.shipping.domain.utils

import com.example.shipping.R

sealed class BottomNavigationScreen(val title: String, val iconId: Int, val route: String) {
    object Menu : BottomNavigationScreen(
        title = "Product List",
        iconId = R.drawable.menu,
        route = "menu_screen"
    )

    object Orders : BottomNavigationScreen(
        title = "Order History",
        iconId = R.drawable.orders,
        route = "orders_screen"
    )

    object Shipping : BottomNavigationScreen(
        title = "Shopping Cart",
        iconId = R.drawable.shipping,
        route = "shipping_screen"
    )

}