package com.example.plannerproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plannerproject.ui.theme.Screen

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