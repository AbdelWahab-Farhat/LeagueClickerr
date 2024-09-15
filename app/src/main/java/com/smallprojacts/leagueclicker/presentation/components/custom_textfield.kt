package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(label: String = "", spaceBetween:Int = 10) {
    val fillColor = Color(0xFFB3E5FC).copy(alpha = 0.2f)
    var text by remember { mutableStateOf("") }
    Column {
        Text(text = label, color = Color(0xffF3F2F3), fontSize = 23.sp)
        Spacer(modifier = Modifier.height(spaceBetween.dp))
        TextField(
            text, { newText -> newText.also { text = it } }, Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            // Update state when text changes
            // Apply rounded corners
            colors = TextFieldDefaults.textFieldColors(
                containerColor = fillColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            )
        )
    }
}
