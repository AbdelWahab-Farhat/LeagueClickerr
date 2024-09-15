package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun ParallelogramShape(color: Color) {
    Canvas(modifier = Modifier.size(35.dp, 25.dp)) {
        val path = Path().apply {
            moveTo(0f, size.height)   // Bottom-left
            lineTo(size.width * 0.65f, size.height)  // Bottom-right
            lineTo(size.width, 0f)    // Top-right
            lineTo(size.width * 0.35f, 0f) // Top-left
            close()
        }

        drawPath(
            path = path,
            color = color
        )
    }
}