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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: String = "",              // Pass current text as a String
    onTextChanged: (String) -> Unit = {},  // Callback to update the text
    label: String?,
    spaceBetween: Int = 10,
    isPassword: Boolean = false,
    isEnabled: Boolean = true,
    suffexicon:  @Composable() (() -> Unit)? = {},
            placeholder:  @Composable() (() -> Unit)? = {}

) {
    val fillColor = Color(0xFFB3E5FC).copy(alpha = 0.2f)

    Column {
        if(label != null) {
            Text(text = label, color = Color(0xffF3F2F3), fontSize = 20.sp)
            Spacer(modifier = Modifier.height(spaceBetween.dp))
        }
        TextField(
            enabled = isEnabled,
            value = text,
            onValueChange = { newText ->
                onTextChanged(newText)
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = fillColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            ),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = true,
            placeholder = placeholder,
            suffix = suffexicon
        )
    }
}
