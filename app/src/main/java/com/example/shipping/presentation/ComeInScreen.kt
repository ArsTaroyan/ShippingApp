package com.example.shipping.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shipping.domain.data.preferences.Preference
import com.example.shipping.domain.data.preferences.Preference.Companion.COMEINCODE
import com.example.shipping.domain.utils.Screen
import kotlinx.coroutines.launch


@Composable
fun ComeInScreen(
    navController: NavHostController,
    preference: Preference?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp, horizontal = 30.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ComeInColum(navController, preference)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComeInColum(navController: NavHostController, preference: Preference?) {
    var textState by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Text(text = "Come in", fontSize = 40.sp, fontWeight = FontWeight.Bold)

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = textState,
        onValueChange = {
            if (it.length <= 5) textState = it
        },
        placeholder = {
            Text(text = "Input your code")
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
            scope.launch {
                if (textState == "11111") {
                    preference?.saveCode(COMEINCODE, textState)
                    navController.navigate(route = Screen.Menu.route) {
                        popUpTo(Screen.ComeIn.route) {
                            inclusive = true
                        }
                    }
                }
            }
        },
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
    ) {
        Text(text = "Come in", color = Color.White, fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ComeInScreenPreview() {
    ComeInScreen(navController = rememberNavController(), preference = null)
}