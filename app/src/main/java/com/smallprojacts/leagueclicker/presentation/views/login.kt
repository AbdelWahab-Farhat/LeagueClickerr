
package com.smallprojacts.leagueclicker.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smallprojacts.leagueclicker.R
import com.smallprojacts.leagueclicker.presentation.components.CustomTextField
import com.smallprojacts.leagueclicker.presentation.components.ImageWithLogo

@Composable
fun LoginView() {
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
        ImageWithLogo(R.drawable.someone)
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-20).dp)
                .padding(horizontal = 20.dp)
        ) {
            CustomTextField(label = "Email")
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(label = "Password")
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Forgot Password ?",
                    color = Color(0xffF3F2F3),
                    fontSize = 15.sp
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp, vertical = 40.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xff785A28),
                                Color(0xC89B3C).copy(alpha = 0.7f)
                            ),
                            start = Offset(0f, 0f), // Top (0% Y-axis)
                            end = Offset(0f, Float.POSITIVE_INFINITY) // Bottom (100% Y-axis)
                        ),
                        shape = RoundedCornerShape(8.dp) // Apply the shape directly to the button
                    ),
                shape = RoundedCornerShape(8.dp), // Ensure the shape matches the background
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent // Make the button's container color transparent
                ),
                contentPadding = PaddingValues(0.dp) // Remove default padding
            ) {
                Text(
                    text = "dwadawd",
                    color = Color(0xffF3F2F3),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun CustomButton(title: String = "Click") {

}

