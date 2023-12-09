package com.example.plannerproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plannerproject.ui.theme.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.PlannerScreen.route
        ){
            PlannerScreen(navController = navController)
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

@Composable
fun PlannerScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(text ="Plan", fontSize = 38.sp, fontWeight = FontWeight.ExtraBold)
                Text(text ="ner", fontSize = 38.sp, color = Color.Red, fontWeight = FontWeight.ExtraBold)
            }
            Button(onClick = {navController.navigate(Screen.MainScreen.route) },colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)) {
                Text("Back")
            }
        }

        Column(
            modifier = Modifier.padding(vertical = 30.dp)
        ) {
            CheckboxLabel(text = "Walk the Dog", points = 55)
            CheckboxLabel(text = "Do physics homework", points = 65)
            CheckboxLabel(text = "prepare for upcoming interview", points = 30)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { },
                modifier= Modifier.size(50.dp),  //avoid the oval shape
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White),
            ) {
                Text("+")
            }
        }


    }
}

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


@Composable
fun LeaderScreen(navController: NavController){
    //Column for the screen title
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row() {
            Text(
                text = "Leader",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "board",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )

        }

        Spacer(modifier = Modifier.height(15.dp))

        //Row to make the columns for Rank, Name, and Score
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //Rank column
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Rank",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "(1)",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )

                Text(
                    text = "(2)",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )

                Text(
                    text = "(3)",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )

                Text(
                    text = "(4)",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "(5)",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            //Name column
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Name",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "You",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "User 1",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "User 5",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "User 2",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "User 4",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            //Score column
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Score",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "999",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "47",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "23",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "15",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "2",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    //Column in upper right of screen for the back button
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ) {
        Button(
            onClick = {
                navController.navigate(Screen.MainScreen.route)
            },
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier.offset((-5).dp, 5.dp)
        ) {
            Text(text = "Back")
        }
    }
}