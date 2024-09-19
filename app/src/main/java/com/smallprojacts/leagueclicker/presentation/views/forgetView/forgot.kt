package com.smallprojacts.leagueclicker.presentation.views.forgetView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.R
import com.smallprojacts.leagueclicker.presentation.components.CustomButton
import com.smallprojacts.leagueclicker.presentation.components.CustomTextField
import com.smallprojacts.leagueclicker.presentation.components.ForgetPasswordButton
import com.smallprojacts.leagueclicker.presentation.components.ImageWithLogo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotView(navController: NavHostController, modifier: Modifier = Modifier){

    var mutableRecovEmail by remember { mutableStateOf("") }
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
            verticalArrangement = Arrangement.Center, // Centering vertically
            horizontalAlignment = Alignment.CenterHorizontally, // Centering horizontally
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Column(
                modifier = modifier
            ) {
                CustomTextField(label = "Recovery Email", isPassword = false, text = mutableRecovEmail,
                    onTextChanged = {
                        mutableRecovEmail = it
                    })
                Spacer(modifier = Modifier.height(8.dp))
                ForgetPasswordButton(onClick = { /*TODO: Add logic*/ }, inForget = 1)
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(onClick = { /*TODO: Add logic*/ }, title = "Confirm Recovery Email")
            }
        }
    }
}
