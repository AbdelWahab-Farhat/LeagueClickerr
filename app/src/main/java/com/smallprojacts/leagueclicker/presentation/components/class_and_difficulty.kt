package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smallprojacts.leagueclicker.R

@Composable
fun ClassAndDifficulty(modifier: Modifier = Modifier, champClass: String, difficulty: Int) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ranger),
                contentDescription = "Image",
                modifier = Modifier.size(77.5.dp),
                contentScale = ContentScale.Fit
            )
            Column {
                Text(
                    "Class",
                    color = Color(0xffF3F2F3),
                    fontSize = 16.sp
                )
                Text(
                    champClass,
                    color = Color(0xffF3F2F3),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column {
            Text(
                "Difficulty",
                color = Color(0xffF3F2F3),
                fontSize = 16.sp
            )
            Text(
                "Easy",
                color = Color(0xffF3F2F3),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            DifficultyMeter(level = difficulty)
        }
    }
}