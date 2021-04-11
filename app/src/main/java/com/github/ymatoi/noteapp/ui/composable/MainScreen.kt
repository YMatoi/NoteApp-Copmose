package com.github.ymatoi.noteapp.ui.composable

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.ymatoi.noteapp.data.enum.Screen


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.name) {
        composable(Screen.Home.name) { HomeScreen(navController) }
        composable(Screen.Edit.name) { EditScreen() }
    }
}