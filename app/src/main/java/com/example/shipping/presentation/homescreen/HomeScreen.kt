package com.example.shipping.presentation.homescreen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shipping.nav.BottomNav
import com.example.shipping.nav.HomeNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = { BottomNav(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}
