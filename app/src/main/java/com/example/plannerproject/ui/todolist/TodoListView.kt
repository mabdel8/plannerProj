package com.example.plannerproject.ui.todolist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.plannerproject.data.Todo

@Composable
fun TodoListView(
    todos: List<Todo>,
    waiting: Boolean,
    onDelete: suspend (Todo) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = modifier
                .padding(5.dp)
        ) {
                LazyColumn {
                    items(todos) { todo ->
                        TodoDetail(todo)
                    }
                }
            }


    }
}