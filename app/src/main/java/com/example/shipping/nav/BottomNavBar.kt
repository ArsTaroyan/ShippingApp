package com.example.shipping.nav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shipping.domain.utils.BottomNavigationScreen

@Composable
fun BottomNav(
    navController: NavController
) {

    val listItems = listOf(
        BottomNavigationScreen.Menu,
        BottomNavigationScreen.Orders,
        BottomNavigationScreen.Shipping
    )

    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {

        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route

        listItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRout == item.route,
                onClick = {
                   navController.navigate(item.route) {
                       popUpTo(route = item.route) {
                           inclusive = true
                       }
                   }
                },
                icon = { 
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray
            )
        }
    }
}