package com.example.plannerproject.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plannerproject.User
import com.example.plannerproject.ui.theme.Screen
import java.util.UUID


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter","UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddFriendScreen(navController: NavController, onAddUser: (User) -> Unit) {


    var inputText by remember { mutableStateOf("")}
    val testFriend2 = User(UUID.randomUUID(),inputText,50)

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        text ="Add Friend",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { navController.navigate(Screen.FriendScreen.route) }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                modifier = Modifier.size(40.dp),
                                contentDescription = null
                            )
                        }
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


    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = inputText,
                modifier = Modifier.height(80.dp).width(300.dp),
               onValueChange = {inputText = it},
                label = {Text(text="Enter Username", fontSize = 30.sp,)}

            )

            ElevatedButton(onClick = {   onAddUser(testFriend2)},
                //shape = CutCornerShape(10),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier.padding(20.dp).height(60.dp).width(160.dp)
            ){Text(text = "Add",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold )

            }
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

