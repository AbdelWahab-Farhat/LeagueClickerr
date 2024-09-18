
package com.smallprojacts.leagueclicker.presentation.views.login
import android.util.Log.d
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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
import com.smallprojacts.leagueclicker.presentation.components.CustomButton
import com.smallprojacts.leagueclicker.presentation.components.CustomTextField
import com.smallprojacts.leagueclicker.presentation.components.ImageWithLogo
import com.smallprojacts.leagueclicker.presentation.components.AuthViewsTextSwitcher
import com.smallprojacts.leagueclicker.presentation.components.ForgetPasswordButton
import kotlinx.coroutines.launch

@Composable
fun LoginView(navController: NavHostController) {
    var mutableEmailText by remember { mutableStateOf("") }
    var mutablePasswordText by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

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
                    val value = NetworkService().loginUser(mutableEmailText, mutablePasswordText)
                    if (value == 1) {
                        // Navigate to main screen and remove the login screen from backstack
                        navController.navigate("main_screen") {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    } else {
                        // Handle login failure, show an error or snack bar
                        d("LoginView", "Login failed. Please check your credentials.")
                    }
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
    }
}
