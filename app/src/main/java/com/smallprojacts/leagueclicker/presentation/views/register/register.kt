package com.smallprojacts.leagueclicker.presentation.views.register

import com.smallprojacts.leagueclicker.data.api.NetworkService
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
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import kotlinx.coroutines.launch

@Composable
fun RegisterView(navController: NavHostController) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var mutableUsernameText by remember { mutableStateOf("") }
    var mutableEmailText by remember { mutableStateOf("") }
    var mutablePasswordText by remember { mutableStateOf("") }
    var mutableConfirmPasswordText by remember { mutableStateOf("") }

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
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(300.dp)) // Adjust height as needed
            CustomTextField(
                label = "Username",
                text = mutableUsernameText,
                onTextChanged = { mutableUsernameText = it })
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                label = "Email",
                text = mutableEmailText,
                onTextChanged = { mutableEmailText = it })
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                label = "Password",
                isPassword = true,
                text = mutablePasswordText,
                onTextChanged = { mutablePasswordText = it })
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                label = "Confirm Password",
                isPassword = true,
                text = mutableConfirmPasswordText,
                onTextChanged = { mutableConfirmPasswordText = it })
            Spacer(modifier = Modifier.height(30.dp))
            CustomButton(onClick = {
                if (mutablePasswordText != mutableConfirmPasswordText) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Passwords do not match")
                    }
                }
                if (mutableEmailText != "" && mutablePasswordText != "" && mutableUsernameText != "" && mutablePasswordText == mutableConfirmPasswordText) {
                    coroutineScope.launch {
                        try {
                            val value = NetworkService().registerUser(
                                mutableUsernameText,
                                mutableEmailText,
                                mutablePasswordText
                            )
                            if (value == 1) {
                                snackbarHostState.showSnackbar("Registration Successfully")
                                navController.navigate("login_view")
                            }
                            else {
                                snackbarHostState.showSnackbar("Registration failed: User already exists")
                            }
                        } catch (e: Exception) {
                            println("Registration failed: ${e.message}")
                            snackbarHostState.showSnackbar("Registration failed: ${e.message}")
                        }
                    }

                }
            }, title = "Register")
            Spacer(modifier = Modifier.height(20.dp))
            AuthViewsTextSwitcher(
                text = "Have an account?",
                clickedText = "Sign in",
                onClick = {
                    navController.navigate("login_view")
                })
            Spacer(modifier = Modifier.height(20.dp))
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter),
            snackbar = { snackbarData ->
                Snackbar(
                    snackbarData = snackbarData,
                    contentColor = Color.White,
                    containerColor = Color(0xFF323232)
                )
            }
        )
    }
}
