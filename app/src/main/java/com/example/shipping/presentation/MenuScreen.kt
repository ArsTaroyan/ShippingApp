package com.example.shipping.presentation

import androidx.compose.foundation.clickable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shipping.domain.data.preferences.Preference
import com.example.shipping.domain.data.preferences.Preference.Companion.COMEINCODE
import com.example.shipping.domain.utils.Screen
import kotlinx.coroutines.launch


@Composable
fun MenuScreen(
    navController: NavHostController,
    preference: Preference?
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .clickable {
                    scope.launch {
                        preference?.removeCode(COMEINCODE)
                    }
                    navController.navigate(route = Screen.ComeIn.route) {
                        popUpTo(Screen.Menu.route) {
                            inclusive = true
                        }
                    }
                },
            text = "Menu", fontSize = 40.sp, fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController(), preference = null)
}