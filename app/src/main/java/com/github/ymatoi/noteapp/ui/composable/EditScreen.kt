package com.github.ymatoi.noteapp.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.github.ymatoi.noteapp.data.dao.NoteDao
import com.github.ymatoi.noteapp.data.entity.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class EditViewModel: ViewModel(), KoinComponent {
    private val dao: NoteDao by inject()

    private val _text = MutableStateFlow("")
    val text: StateFlow<String> = _text
    fun onTextChanged(new: String) {
        _text.value = new
    }

    fun save() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertAll(Note(text = text.value))
        }
    }
}

@Composable
fun EditScreen(navController: NavController ,editViewModel: EditViewModel = viewModel()) {
    val text: String by editViewModel.text.collectAsState()
    Column {
        TextField(
            value = text,
            onValueChange = { editViewModel.onTextChanged(it) },
            label = { Text(text = "text") }
        )
        Button(
            onClick = {
                editViewModel.save()
                navController.popBackStack()
            }
        ) {
            Text(text = "save")
        }
    }
}