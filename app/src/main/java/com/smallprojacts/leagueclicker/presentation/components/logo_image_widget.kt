package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.smallprojacts.leagueclicker.R

// Later we will add Image Parameter
@Composable
fun ImageWithLogo(backgroundPhotoId:Int) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = backgroundPhotoId), // Replace with your drawable resource ID
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
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logowhite),
            contentDescription = "Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}