package com.smallprojacts.leagueclicker.presentation.views.login

import TokenManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.R
import com.smallprojacts.leagueclicker.data.api.NetworkService
import com.smallprojacts.leagueclicker.presentation.components.AuthViewsTextSwitcher
import com.smallprojacts.leagueclicker.presentation.components.CustomButton
import com.smallprojacts.leagueclicker.presentation.components.CustomTextField
import com.smallprojacts.leagueclicker.presentation.components.ForgetPasswordButton
import com.smallprojacts.leagueclicker.presentation.components.ImageWithLogo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginView(navController: NavHostController) {
    var mutableEmailText by remember { mutableStateOf("") }
    var mutablePasswordText by remember { mutableStateOf("") }
    var showSnackbar by remember { mutableStateOf(false) }
    var snackbarMessage by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xff091428), Color(0xff0A1428)),
                    start = Offset(0f, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
    ) {
        ImageWithLogo(R.drawable.someone)
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-20).dp)
                .padding(horizontal = 20.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(340.dp))

            CustomTextField(label = "Email", text = mutableEmailText, onTextChanged = {
                mutableEmailText = it
            })

            Spacer(modifier = Modifier.height(20.dp))

            CustomTextField(label = "Password", isPassword = true, text = mutablePasswordText, onTextChanged = {
                mutablePasswordText = it
            })

            Spacer(modifier = Modifier.height(8.dp))

            ForgetPasswordButton(onClick = {})

            Spacer(modifier = Modifier.height(50.dp))

            CustomButton(onClick = {
                coroutineScope.launch {
                     NetworkService().loginUser(mutableEmailText, mutablePasswordText)
                    if (TokenManager.getToken() != null) {
                        navController.navigate("main_screen") {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                        snackbarMessage = "Login successful!"
                    } else {
                        snackbarMessage = "Login failed. Please check your credentials."
                    }
                    showSnackbar = true
                }
            }, title = "Login")

            Spacer(modifier = Modifier.height(40.dp))

            AuthViewsTextSwitcher(
                text = "Don't have an account?",
                clickedText = "Sign Up!",
                onClick = {
                    navController.navigate("register_view")
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        if (showSnackbar) {
            CustomSnackbar(
                message = snackbarMessage,
                onDismiss = {
                    showSnackbar = false
                }
            )
        }
    }
}
@Composable
fun CustomSnackbar(
    message: String,
    onDismiss: () -> Unit
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Snackbar(
            containerColor = Color.Black,
            content = {
                Text(message, color = Color.White)
            },
            action = {
                // Optionally add an action button
            },
            modifier = Modifier.fillMaxWidth()
        )

        LaunchedEffect(Unit) {
            delay(3000) // Automatically dismiss after 3 seconds
            onDismiss()
        }
    }
}

