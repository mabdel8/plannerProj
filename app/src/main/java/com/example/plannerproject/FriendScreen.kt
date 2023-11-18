package com.example.plannerproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plannerproject.ui.theme.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendScreen(navController: NavController){
    //buttons, Buttos are all layedout on the right side of the screen
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ) {
        //back button will be used to take you back to main menu
        Button(
            onClick = {navController.navigate(Screen.MainScreen.route)},
            colors = ButtonDefaults.buttonColors(Color.Red),
            //shape = RectangleShape,
            modifier = Modifier.offset(-5.dp, 5.dp)
        ) {
            Text(text = "Back")
        }
        //delete buttons, we are going to the friends into a list
        //similar to the songlist lab, and you will be able to add friends to the list
        //and delete friends from the list. currently we showed a model
        //of what it will possibly looklike
        ElevatedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.offset(0.dp, 15.dp)
        ) {
            Text(text = "Del", color = Color.Red)
        }
        ElevatedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.offset(0.dp, 30.dp)
        ) {
            Text(text = "Del", color = Color.Red)
        }
        ElevatedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.offset(0.dp, 45.dp)
        ) {
            Text(text = "Del", color = Color.Red)
        }
        ElevatedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.offset(0.dp, 60.dp)
        ) {
            Text(text = "Del", color = Color.Red)
        }







    }
//This section of code is used for the Friends List title at the top
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // we make one half black and one half red to be consistent with our modern theme
        //we have going through the entire project
        Row() {
            Text(
                text = "Friends",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                // modifier = Modifier.offset(-80.dp, -50.dp)
            )
            Text(
                text = " List",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                //   modifier = Modifier.offset(-80.dp, -50.dp)
            )

        }

        //list of all the friends on the friends list
        //we plan on making this into an actual list as mentioned earlier
        Text(
            text = "User 2",
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "User 5",
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )

        Text(
            text = "User 4",
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "User 1",
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )


        //textfield, this section of code is used for the text field
        //we plan to use the text field to add friends to the list
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            OutlinedTextField(

                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "Add Friends")
                },
                modifier = Modifier.offset(0.dp, -20.dp)

            )
        }
    }
//text input
}

//test code to see if commits still work