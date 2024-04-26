package com.example.shipping.domain.utils

sealed class Screen(val route: String) {
    object ComeIn: Screen(route = "come_in_screen")
}