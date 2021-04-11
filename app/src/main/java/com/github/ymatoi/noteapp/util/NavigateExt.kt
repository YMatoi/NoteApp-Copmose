package com.github.ymatoi.noteapp.util

import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.github.ymatoi.noteapp.data.enum.Screen

fun NavController.navigate(screen: Screen) {
    this.navigate(screen.name)
}