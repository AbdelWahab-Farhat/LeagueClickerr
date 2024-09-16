package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.smallprojacts.leagueclicker.R

// Later we will add Image Parameter
@Composable
fun ImageWithLogo(backgroundPhotoId:Int , imageHeight:Int = 360 , logoPositionY:Int = 250, logoPositionX:Int = 7) {
    Box(
        modifier = Modifier.size(height = imageHeight.dp, width = 1000.dp)
    ) {
        Image(
            painter = painterResource(backgroundPhotoId),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(imageHeight.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(height = 130.dp, width = 1000.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0x00091428), Color(0xff0A1428)),
                        start = Offset(0f, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                )
        ) {}
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .offset(x = logoPositionX.dp, y = (-logoPositionY).dp),
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