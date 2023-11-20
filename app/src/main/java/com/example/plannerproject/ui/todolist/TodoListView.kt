package com.example.plannerproject.ui.todolist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plannerproject.data.Todo
import com.example.plannerproject.ui.AddTaskScreen
import com.example.plannerproject.ui.theme.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListView(
    todos: List<Todo>,
    waiting: Boolean,
    onDelete: suspend (Todo) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier,

) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Column(

        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        colors = topAppBarColors(
                            containerColor = Color.Red,
                            titleContentColor = Color.White,
                        ),
                        title = {
                            Text(
                                text ="Task List",
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                IconButton(onClick = { navController.navigate(Screen.MainScreen.route) }) {
                                    Icon(
                                        imageVector = Icons.Default.ExitToApp,
                                        modifier = Modifier.size(40.dp),
                                        contentDescription = null
                                    )
                                }
                            }
                        })

                },
                floatingActionButton = {
                    ExtendedFloatingActionButton(
                        containerColor = Color.Red,
                        contentColor = Color.White,
                        onClick = {navController.navigate(Screen.AddTaskScreen.route)},
                        icon = { Icon(
                            Icons.Default.Add,
                            modifier = Modifier.size(30.dp),
                            contentDescription = "Add",
                            tint = Color.White)},
                        text = { Text(text = " Add Task",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold)}
                    )
                }

            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        items(todos) { todo ->
                            TodoDetail(todo)
                        }
                    }
                }
            }

            }


    }
}

//@Composable
//fun callAddScreen(navController: NavController) {
//    AddTaskScreen(navController = navController)
//}