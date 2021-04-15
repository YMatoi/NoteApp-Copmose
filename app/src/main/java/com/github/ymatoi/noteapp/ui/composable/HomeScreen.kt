package com.github.ymatoi.noteapp.ui.composable

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.github.ymatoi.noteapp.data.dao.NoteDao
import com.github.ymatoi.noteapp.data.entity.Note
import com.github.ymatoi.noteapp.data.enum.Screen
import com.github.ymatoi.noteapp.util.navigate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel: ViewModel(), KoinComponent {
    private val dao: NoteDao by inject()
    val notes = dao.getAll().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = viewModel()) {
    val notes by homeViewModel.notes.collectAsState()

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        val (list, fab) = createRefs()

        LazyColumn(
            modifier = Modifier.constrainAs (list) {
                top.linkTo(parent.top, margin = 16.dp)
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        ) {
            items(notes) {
                Text(text = it.text)
            }
        }

        FloatingActionButton(
            onClick = { navController.navigate(Screen.Edit) },
            modifier = Modifier.constrainAs(fab) {
                end.linkTo(parent.end, margin = 16.dp)
                bottom.linkTo(parent.bottom, margin = 16.dp)
            }
        ) {
            Icon(imageVector = Icons.Filled.Add , contentDescription = "Add")
        }
    }
}
