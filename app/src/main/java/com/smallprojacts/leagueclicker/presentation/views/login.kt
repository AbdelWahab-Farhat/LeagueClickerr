
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
import com.smallprojacts.leagueclicker.presentation.components.ForgetPasswordButton

@Composable
fun LoginView(navController: NavHostController) {
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
                .padding(horizontal = 20.dp).fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(340.dp))
            CustomTextField(label = "Email")
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(label = "Password", isPassword = true)
            Spacer(modifier = Modifier.height(8.dp))
            ForgetPasswordButton(onClick = {})
            Spacer(modifier = Modifier.height(50.dp))
            // TODO: COMPLETE LOGIN LOGIC BUTTON
            CustomButton(onClick = {}, title = "Login")
            Spacer(modifier = Modifier.height(40.dp))
            AuthViewsTextSwitcher(onClick = {})
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}



