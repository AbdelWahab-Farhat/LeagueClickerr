package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smallprojacts.leagueclicker.R


@Composable
fun ProfileNav(name: String = "Ace D Roger", imageId:Int = R.drawable.champ1) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
  ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(imageId),
                contentDescription = "Image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(
                        2.dp, Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF005A82),
                                Color(0xFF0AC8B9)
                            )
                        ), CircleShape
                    ),
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(64.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Welcome back",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }

        }

        IconButton(onClick = { /* do something */ }, modifier = Modifier.size(64.dp)) {
            Icon(

                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notfi",
                tint = Color.White
            )
        }
    }
}