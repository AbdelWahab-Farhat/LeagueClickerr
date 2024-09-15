package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun  CustomButton (onClick: () -> Unit , title: String = "Confirm" , ) {
    Box(
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xff785A28),
                            Color(0xffC89B3C).copy(alpha = 0.7f)
                        ),
                        start = Offset(0f, 0f), // Top (0% Y-axis)
                        end = Offset(0f, Float.POSITIVE_INFINITY) // Bottom (100% Y-axis)
                    ),
                    shape = RoundedCornerShape(8.dp) // Apply the shape directly to the button
                ),
            shape = RoundedCornerShape(8.dp), // Ensure the shape matches the background
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            contentPadding = PaddingValues(0.dp) // Remove default padding
        ) {
            Text(
                text = title,
                color = Color(0xffF3F2F3),
                fontSize = 20.sp
            )
        }
    }
}