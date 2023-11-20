package com.example.plannerproject.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plannerproject.ui.theme.Screen
import com.example.plannerproject.ui.todolist.TodoListView
import com.example.plannerproject.ui.todolist.TodoListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val vm: TodoListViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.PlannerScreen.route
        ){
//            PlannerScreen(navController = navController)
            TodoListScreen(vm,navController)
        }
        composable(
            route = Screen.FriendScreen.route
        ){
            FriendScreen(navController = navController)
        }
        composable(
            route = Screen.LeaderScreen.route
        ){
            LeaderScreen(navController = navController)
        }
        composable(
            route = Screen.AddTaskScreen.route
        ){
            AddTaskScreen(navController,
                onAddTodo = { todo ->
                    vm.addTodo(todo)
                    navController.popBackStack()
                })
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    //main column for text and buttons
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        //Settings for the Title, made the second half red to give it a slicker look
        Row{
            Text(
                text = "LifeMade",
                fontSize =50.sp,
                modifier = Modifier.offset(0.dp, 50.dp),
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "EZ",
                color = Color.Red,
                fontSize =50.sp,
                modifier = Modifier.offset(0.dp, 50.dp),
                fontWeight = FontWeight.Bold
            )
        }

        //Quote of the day Text, we plane to have an array of random quotes that will randomly
        //change everytime you open the main screen
        Text(
            text = "Quote of the Day: ",
            fontWeight = FontWeight.Bold,
            fontSize =20.sp,
            modifier = Modifier.offset(0.dp, 60.dp)
        )
        Text (
            text = "Failure is success in progress!",
            fontSize =20.sp,
            modifier = Modifier.offset(0.dp, 60.dp)
        )
// these buttons will take you to each of the different screens: Planner, Friends list
        //and Leaderboard
        Button(onClick ={navController.navigate(Screen.PlannerScreen.route)},
            //shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier
                .offset(0.dp, 100.dp)
                .height(75.dp)
                .width(300.dp)
        ){
            Text(text = "Planner", fontSize = 40.sp)
        }

        Button(onClick ={navController.navigate(Screen.FriendScreen.route)},
            //shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier
                .offset(0.dp, 140.dp)
                .height(75.dp)
                .width(300.dp)
        ){
            Text(text = "Friends List", fontSize = 40.sp)
        }

        Button(onClick ={navController.navigate(Screen.LeaderScreen.route)},
            //shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier
                .offset(0.dp, 180.dp)
                .height(75.dp)
                .width(300.dp)
        ){
            Text(text = "Leaderboard", fontSize = 40.sp)
        }

        //this section displays the users current score, the users score will increase
        //depening on what task he completes in his planner
        //the users position on the leaderboard will also increase or decrease if he has
        //more or less points then his friends on his friends list
        Text(
            text = "Current Score:",
            fontSize =30.sp,
            modifier = Modifier.offset(0.dp, 220.dp),
            fontWeight = FontWeight.Bold
        )
        //we currently set the users score to 999 for this prototype
        Row {
            Text(
                text = "999",
                fontSize =50.sp,
                modifier = Modifier.offset(0.dp, 230.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Red,
            )
            /*Text(
                text = "Pts",
                fontSize =30.sp,
                modifier = Modifier.offset(0.dp, 250.dp),
                fontWeight = FontWeight.Bold,
            ) */
        }




    }
}

@OptIn(ExperimentalLayoutApi::class)
@ExperimentalFoundationApi
@Composable
fun TodoListScreen(
    vm: TodoListViewModel,
    navController: NavController
) {
    val todos by vm.todos
    val waiting by vm.waiting

    TodoListView(
        todos,
        waiting,
        onDelete =vm::deleteTodo,
        navController
    )
}

