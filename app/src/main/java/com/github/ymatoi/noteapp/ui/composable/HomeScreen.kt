package com.github.ymatoi.noteapp.ui.composable

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.github.ymatoi.noteapp.data.enum.Screen
import com.github.ymatoi.noteapp.util.navigate

class HomeViewModel: ViewModel(){
}

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = viewModel()) {
    Button(onClick = { navController.navigate(Screen.Edit)}) {
        Text("navigate to edit screen")
    }
}