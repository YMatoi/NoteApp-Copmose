package com.github.ymatoi.noteapp.ui.composable

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.github.ymatoi.noteapp.data.enum.Screen
import com.github.ymatoi.noteapp.util.navigate

@Composable
fun HomeScreen(navController: NavController) {
    Button(onClick = { navController.navigate(Screen.Edit)}) {
        Text("navigate to edit screen")
    }
}