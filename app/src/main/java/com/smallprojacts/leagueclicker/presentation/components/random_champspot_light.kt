package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smallprojacts.leagueclicker.R


@Composable
fun RandomChampSpotLight(
    modifier: Modifier,
    quote: String = "“Ayyy im jinx”",
    imageId: Int = R.drawable.jinx,
    lvl: String = "10",
    items: String = "Infinity Edge , Rabadon's Deathcap , Thornmail , Sunfire Aegis ,Guardian Angel "
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = quote,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))

        Image(
            modifier = modifier
                .fillMaxWidth()
                .height(340.dp),
            painter = painterResource(imageId), contentDescription = "Champ"
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xff785A28), Color(0xffC89B3C)),

                            )
                    )
                ) {
                    append("Lvl")
                }
                append(" $lvl")
            },
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )


        Text(
            textAlign = TextAlign.Center,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth(1f),
            text = "Current Items : $items ",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )

    }
}