package com.smallprojacts.leagueclicker.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
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
import com.smallprojacts.leagueclicker.presentation.components.ImageWithLogo
import com.smallprojacts.leagueclicker.presentation.components.AuthViewsTextSwitcher


@Composable
fun RegisterView(navController: NavHostController) {
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
            ImageWithLogo(R.drawable.someone2)
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (-20).dp)
                    .padding(horizontal = 20.dp)
                    .fillMaxSize().verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(300.dp)) // Adjust height as needed
                CustomTextField(label = "Username")
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(label = "Email")
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(label = "Password", isPassword = true)
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(label = "Confirm Password", isPassword = true)
                Spacer(modifier = Modifier.height(30.dp))
                CustomButton(onClick = {}, title = "Register")
                Spacer(modifier = Modifier.height(20.dp))
                AuthViewsTextSwitcher(
                    text = "Have an account?",
                    clickedText = "Sign in",
                    onClick = {
                    navController.navigate("login_view")
                })
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
