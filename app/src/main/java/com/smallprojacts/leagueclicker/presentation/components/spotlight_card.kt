package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.smallprojacts.leagueclicker.R
import com.smallprojacts.leagueclicker.domain.models.AllChamp

@Composable
fun SpotlightCard(modifier: Modifier = Modifier, champs: List<AllChamp>) {
    val shuffledchamps = champs.shuffled()
    var champp:AllChamp? = null
    for (champ in shuffledchamps) {
        if (champ.championImageFullBody != null) {
            champp = champ;
            break;
        }
    }
    var imageBackground = R.drawable.background1
    if (champp?.region?.id == 1) {
         imageBackground = R.drawable.background2
    }
    else if (champp?.region?.id == 2){
        imageBackground = R.drawable.background2
    }
    else if (champp?.region?.id == 3) {
        imageBackground = R.drawable.background1
    }
    else if (champp?.region?.id == 4) {
        imageBackground = R.drawable.piltover_impacts_across_valoran
    }
    else if (champp?.region?.id == 8) {
        imageBackground = R.drawable.bilgewater_a_new_beginning
    }
    else if (champp?.region?.id == 10) {
        imageBackground = R.drawable.bandlbg
    }
    else if (champp?.region?.id == 11) {
        imageBackground = R.drawable.freljord_vaults_of_the_iceborn
    }
    else {
        imageBackground = R.drawable.background1
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clip(shape = RoundedCornerShape(8)),
        ) {
            Box(
            ) {
                if (champp?.region != null) {
                    Image(
                        painter = painterResource(id = imageBackground),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.FillWidth,
                        contentDescription = "Spotlighted Champion Card",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(8)),
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                         text = champp?.name ?: "Opp's we have null value's",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(1f),
                        text = champp?.title ?: "Opp's we have null value's",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color =  Color.White
                    )
                    Spacer(Modifier.height(24.dp))
                    Box(
                        modifier = Modifier.clip(shape = RoundedCornerShape(20))
                            .background(Color(0xFF1E1F24))
                    ) {
                        IconButton(
                            onClick = {},
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color(0xFF1E1F24)
                            ),
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                                contentDescription = "Search Icon",
                                tint = Color.White,
                            )
                        }
                    }
                }
            }
        }
        if (champp != null) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(champp.championImageFullBody)
                        .crossfade(true) // Optional: Enable fade-in animation
                        .build()
                ),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.FillHeight,
                contentDescription = "Spotlighted Champion Card"
            )
        }
    }
}
