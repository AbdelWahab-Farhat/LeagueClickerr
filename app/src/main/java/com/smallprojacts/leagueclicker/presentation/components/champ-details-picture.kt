package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smallprojacts.leagueclicker.R

@Composable
fun ChampionDetailsPicture(
    modifier: Modifier = Modifier,
    name: String,
    level: Int?,
    title: String?,
    numOfClicks: Int?
) {
    Box(
        modifier = Modifier.size(height = 360.dp, width = 1000.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.champ1),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(height = 130.dp, width = 1000.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0x00091428), Color(0xff0A1428)),
                        start = Offset(0f, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                )
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        name,
                        color = Color(0xffF3F2F3),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (level != null) {
                        Text(
                            "lvl: $level",
                            color = Color(0xffF3F2F3),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        title ?: "Number Of Clicks",
                        color = Color(0xDDF3F2F3),
                        fontSize = 20.sp
                    )

                    if (numOfClicks != null) {
                        Text(numOfClicks.toString(), color = Color(0xDDF3F2F3), fontSize = 20.sp)
                    }
                }
            }
        }
    }
}