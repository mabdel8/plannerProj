package com.example.plannerproject

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plannerproject.ui.theme.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendScreen(navController: NavController) {

    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        text ="Friends List",
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
                onClick = {navController.navigate(Screen.AddFriendScreen.route)},
                icon = { Icon(
                    Icons.Default.Add,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "Add",
                    tint = Color.White)},
                text = { Text(text = " Add Friend",
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
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Lazy column"
            )
        }
    }
}

    //buttons, Buttos are all layedout on the right side of the screen
        //back button will be used to take you back to main menu
       /* Button(
            onClick = { navController.navigate(Screen.MainScreen.route) },
            colors = ButtonDefaults.buttonColors(Color.Red),
            //shape = RectangleShape,
            modifier = Modifier.offset(-5.dp, 5.dp)
        ) {
            Text(text = "Back")
        } */

