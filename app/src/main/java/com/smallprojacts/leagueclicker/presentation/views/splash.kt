package com.smallprojacts.leagueclicker.presentation.views

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.R
import com.smallprojacts.leagueclicker.presentation.components.ImageWithLogo
import androidx.compose.animation.core.animateDpAsState
import kotlinx.coroutines.time.delay
import java.time.Duration

@Composable
fun SplashView(navController: NavHostController) {
    // State to trigger the animation
    var textOffsetY by remember { mutableStateOf(300.dp) } // Start off-screen (below)

    // Animate the text's Y offset from 300.dp to 120.dp
    val animatedTextOffsetY by animateDpAsState(
        targetValue = textOffsetY,
        animationSpec = tween(durationMillis = 1000), label = "" // 1-second animation
    )

    LaunchedEffect(Unit) {
        textOffsetY = 140.dp
        delay(duration = Duration.ofSeconds(1))
        navController.navigate("login_view")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xff091428), Color(0xff0A1428)),
                    start = Offset(0f, 0f), // Top (0% Y-axis)
                    end = Offset(0f, Float.POSITIVE_INFINITY) // Bottom (100% Y-axis)
                )
            )
    ) {
        ImageWithLogo(
            backgroundPhotoId = R.drawable.someone3,
            imageHeight = 450,
            logoPositionY = 0,
            logoPositionX = 7
        )

        // Animated text
        Text(
            text = "League Clicker",
            fontSize = 40.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = 0.dp, y = animatedTextOffsetY), // Use animated offset for Y position
            color = Color.White
        )
    }
}
