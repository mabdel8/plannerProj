package com.example.plannerproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Delete
import com.example.plannerproject.CheckboxLabel
import com.example.plannerproject.User

@Composable
fun UserDetail(
    user: User
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(containerColor = Color.Red, contentColor = Color.White),
        border = BorderStroke(3.dp, Color.White),
        modifier = Modifier.size(width = 400.dp, height = 100.dp).padding(5.dp)

    ) {
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
               // horizontalArrangement = Arrangement.Start
            ) {
              Text(text = user.userName, fontSize = 30.sp,
                  fontWeight = FontWeight.Bold)
                /*Text(text = "$user.score", fontSize = 30.sp,
                    fontWeight = FontWeight.Bold)*/
            }
        }
    }
}