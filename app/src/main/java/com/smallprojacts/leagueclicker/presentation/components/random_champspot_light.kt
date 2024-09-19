package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.smallprojacts.leagueclicker.domain.models.AllChamp
import kotlin.random.Random

@Composable
fun RandomChampSpotLight(
    champs: List<AllChamp>,  // List of champions
    modifier: Modifier = Modifier,  // Modifier with default value
    quote: String = "“Ayyy im Jinx”",
    lvl: String = "10",
    items: String = "Infinity Edge, Rabadon's Deathcap, Thornmail, Sunfire Aegis, Guardian Angel"
) {
    // Select a random champion with a valid image
    val filteredChamps = champs.filter { it.championImageFullBody != null }
    val randomChamp = if (filteredChamps.isNotEmpty()) {
        filteredChamps[Random.nextInt(filteredChamps.size)]
    } else {
        null
    }
    val randomNumber = Random.nextInt(1, 101)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Quote Text
        Text(
            text = randomChamp?.name?: "Opp's we Have Null From Backend :3",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Image with loading effect
        randomChamp?.championImageFullBody?.let { imageUrl ->
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true) // Enable crossfade animation for smooth loading
                    .build(),
                contentDescription = "Champion Image",
                modifier = modifier
                    .fillMaxWidth()
                    .height(340.dp),
                loading = {
                    // Show a circular progress indicator while loading
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(340.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Color.White)
                    }
                },
                error = {
                    // Show an error placeholder if the image fails to load
                    Text(
                        text = "Failed to load champion image",
                        color = Color.Red,
                        fontSize = 16.sp
                    )
                }
            )
        } ?: run {
            // Fallback: If no champion has a valid image
            Text(
                text = "No champion image available",
                fontSize = 20.sp,
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Level Text with Gradient
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xff785A28), Color(0xffC89B3C))
                        )
                    )
                ) {
                    append("Level")
                }
                append(" $randomNumber")
            },
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        // Items Text
        Text(
            textAlign = TextAlign.Center,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth(),
            text = "Current Items: $items",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}
