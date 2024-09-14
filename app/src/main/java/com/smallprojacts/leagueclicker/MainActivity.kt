package com.smallprojacts.leagueclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smallprojacts.leagueclicker.ui.theme.LeagueClickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeagueClickerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    container();
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CustomTextField() {
    // Define your fill color with opacity
    val fillColor = Color(0xFFB3E5FC).copy(alpha = 0.2f) // Light Blue color with 20% opacity

    // State to manage the text input
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText -> text = newText }, // Update state when text changes
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)), // Apply rounded corners
        colors = TextFieldDefaults.textFieldColors(
            containerColor = fillColor,
            focusedIndicatorColor = Color.Transparent, // Remove focus indicator
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White
        )
    )
}


@Composable
fun container (){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xff091428), Color(0xff0A1428)),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
    ) {
        ImageWithLogo()
        Column (
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = -20.dp)
                .padding(horizontal = 20.dp)
        ){
            Column {
                Text(text = "Email", color = Color(0xffF3F2F3), fontSize = 23.sp)
                Spacer(modifier = Modifier.height(8.dp))
                CustomTextField()
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column {
                Text(text = "Password", color = Color(0xffF3F2F3), fontSize = 23.sp)
                Spacer(modifier = Modifier.height(8.dp))
                CustomTextField()
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End, // Align children to the end of the Row
                    verticalAlignment = Alignment.CenterVertically // Optionally center vertically
                ) {
                    Text(
                        text = "Forgot Password?",
                        color = Color(0xffF3F2F3),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

// Later we will add Image Parameter
@Composable fun ImageWithLogo() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.someone), // Replace with your drawable resource ID
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.Crop
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize() // Make the Box fill the available space
            .offset(x = 7.dp, y = (-250).dp),
        contentAlignment = Alignment.Center // Center content within the Box
    ) {
        Image(
            painter = painterResource(id = R.drawable.logowhite), // Replace with your drawable resource ID
            contentDescription = "Image",
            contentScale = ContentScale.Fit, // Adjust image scaling to fit within the Box
            modifier = Modifier
                .fillMaxWidth() // Make the image fill the width of the Box
        )
    }
}