package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smallprojacts.leagueclicker.R

@Composable
fun SpotlightCard(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clip(shape = RoundedCornerShape(8)),
        ) {
            Box(
            ) {
                Image(
                    painter = painterResource(R.drawable.yasoubg),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "Spotlighted Champion Card",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(8)),
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Yasuo",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(1f),
                        text = "The Unforgivable",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                    Spacer(Modifier.height(24.dp))
                    Box(
                        modifier = Modifier.clip(shape = RoundedCornerShape(20))
                            .background(Color(0xFF1E1F24))
                    ) {
                        IconButton(
                            onClick = {},
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color(0xFF1E1F24)
                            ),
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                                contentDescription = "Search Icon",
                                tint = Color.White,
                            )
                        }
                    }
                }
            }
        }
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.yasou),
            alignment = Alignment.CenterEnd,
            contentScale = ContentScale.FillHeight,
            contentDescription = "Spotlighted Champion Card"
        )
    }
}