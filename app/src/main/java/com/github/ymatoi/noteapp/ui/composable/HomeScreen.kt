package com.github.ymatoi.noteapp.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.github.ymatoi.noteapp.data.dao.NoteDao
import com.github.ymatoi.noteapp.data.entity.Note
import com.github.ymatoi.noteapp.data.enum.Screen
import com.github.ymatoi.noteapp.util.navigate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel: ViewModel(), KoinComponent {
    private val dao: NoteDao by inject()
    val notes = dao.getAll()

    init {
        //TODO: remove this
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertAll(Note(text = "test"))
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = viewModel()) {
    val notes = homeViewModel.notes.observeAsState(emptyList())
    Column {
        LazyColumn {
            items(notes.value) {
                Text(text = it.text)
            }
        }
        Button(onClick = { navController.navigate(Screen.Edit)}) {
            Text("navigate to edit screen")
        }
    }
}