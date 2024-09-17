package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smallprojacts.leagueclicker.R

@Composable
fun ChampionGrid(modifier: Modifier = Modifier, champs: Map<String, Int>, itemsPerRow: Int = 3) {
    val statList = champs.toList().chunked(itemsPerRow)
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        statList.forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                rowItems.forEach { (stat, value) ->
                    ChampionCard(champ = value)
                }
            }
        }
    }
}

@Composable
fun ChampionCard(modifier: Modifier = Modifier, champ: Int) {
    Column(horizontalAlignment = Alignment.Start) {
        Card(
            modifier = Modifier    // Fixing the modifier reference
                .height(130.dp)
                .width(110.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xff2B2C33)
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.champ1),  // Ensure this resource exists
                    contentDescription = "Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop  // Adjust image scaling
                )
            }
        }

        // Champion name
        Text(
            text = "Ezreal",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        // Subtitle text
        Text(
            modifier = Modifier.width(100.dp),
            text = "The Explorer is here to Stay",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}
