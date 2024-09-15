package com.smallprojacts.leagueclicker.presentation.views.my_champ_details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.R
import com.smallprojacts.leagueclicker.presentation.components.CustomButton
import com.smallprojacts.leagueclicker.presentation.components.CustomChampTopBar
import com.smallprojacts.leagueclicker.presentation.components.StatMeterGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyChampScreen(modifier: Modifier = Modifier, navController: NavHostController) {
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
        Scaffold(
            modifier = modifier,
            containerColor = Color.Transparent,
            topBar = {
                CustomChampTopBar()
            },
        ) { innerPadding ->
            val stats = mapOf(
                "Strength" to 1,
                "Intelligence" to 5,
                "Speed" to 3,
                "Health" to 2,
                "Attack Damage" to 4,
                "Ability Power" to 1
            )

            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier.size(height = 360.dp, width = 1000.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.champ1),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(360.dp),
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
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Column {
                            Row(
                                modifier = modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    "Ezreal",
                                    color = Color(0xffF3F2F3),
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "lvl: 10",
                                    color = Color(0xffF3F2F3),
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row(
                                modifier = modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    "Number Of Clicks",
                                    color = Color(0xDDF3F2F3),
                                    fontSize = 20.sp
                                )
                                Text("30,000", color = Color(0xDDF3F2F3), fontSize = 20.sp)
                            }
                        }
                    }
                }

                Column(
                    modifier = modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp),
                ) {
                    Text(
                        "Stats",
                        color = Color(0xffF3F2F3),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = modifier.size(10.dp))

                    StatMeterGrid(statMap = stats)

                    Spacer(modifier = modifier.size(30.dp))

                    Text(
                        "Items & Skills",
                        color = Color(0xffF3F2F3),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                LazyRow(
                    modifier = modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(start = 20.dp)
                ) {
                    item {
                        Image(
                            painter = painterResource(R.drawable.skill1),
                            contentDescription = "Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(55.dp, 55.dp)
                                .clip(RoundedCornerShape(10)),
                            contentScale = ContentScale.Crop
                        )
                    }
                    item {
                        Box(modifier = modifier.size(75.dp, 90.dp)) {
                            Box(
                                modifier = modifier
                                    .size(70.dp, 70.dp)
                                    .border(
                                        border = BorderStroke(
                                            2.dp, brush = Brush.linearGradient(
                                                colors = listOf(
                                                    Color(0xff005A82),
                                                    Color(0xff0AC8B9)
                                                ),
                                                start = Offset(0f, 0f),
                                                end = Offset(0f, Float.POSITIVE_INFINITY)
                                            )
                                        )
                                    )
                            ) {}
                            Box(
                                modifier = modifier
                                    .offset(5.dp, 5.dp)
                                    .size(70.dp, 70.dp)
                                    .border(
                                        border = BorderStroke(
                                            2.dp, brush = Brush.linearGradient(
                                                colors = listOf(
                                                    Color(0xff005A82),
                                                    Color(0xff0AC8B9)
                                                ),
                                                start = Offset(0f, 0f),
                                                end = Offset(0f, Float.POSITIVE_INFINITY)
                                            )
                                        )
                                    )
                            ) {}
                            Box(
                                modifier = modifier
                                    .align(alignment = Alignment.BottomCenter)

                                    .size(2.dp, 15.dp)
                                    .border(
                                        border = BorderStroke(
                                            1.dp, brush = Brush.linearGradient(
                                                colors = listOf(
                                                    Color(0xff0AC8B9),
                                                    Color(0xff005A82)
                                                ),
                                                start = Offset(0f, 0f),
                                                end = Offset(0f, Float.POSITIVE_INFINITY)
                                            )
                                        )
                                    )
                            ) {}
                            Image(
                                painter = painterResource(R.drawable.skill1),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .align(alignment = Alignment.TopCenter)
                                    .offset(0.dp, 7.5.dp)
                                    .size(60.dp, 60.dp)
                                    .clip(RoundedCornerShape(0)),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    items(5) {
                        Image(
                            painter = painterResource(R.drawable.skill1),
                            contentDescription = "Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(55.dp, 55.dp)
                                .clip(RoundedCornerShape(10)),
                            contentScale = ContentScale.Crop
                        )

                    }
                }
                Box(
                    modifier = modifier
                        .size(1000.dp, 2.dp)
                        .border(
                            border = BorderStroke(
                                1.dp, brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xff005A82),
                                        Color(0xff0AC8B9)
                                    ),
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, Float.POSITIVE_INFINITY)
                                )
                            )
                        )
                ) { }
                Spacer(Modifier.size(20.dp))
                Text(
                    "Potato Ability",
                    color = Color(0xffF3F2F3),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(start = 20.dp, bottom = 5.dp)
                )
                Text(
                    "dla;sjkdm lsajkdlas jdlasj dalsjd lasjd lasjdlasj dlasd jasld jasl djasld jasld jasld jawl djasd ljsal dj",
                    color = Color(0xffF3F2F3),
                    fontSize = 16.sp,
                    modifier = modifier.padding(horizontal = 20.dp)
                )
                Spacer(Modifier.size(20.dp))
                Box(
                    modifier = modifier
                        .size(1000.dp, 2.dp)
                        .border(
                            border = BorderStroke(
                                1.dp, brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xff0AC8B9),
                                        Color(0xff005A82)
                                    ),
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, Float.POSITIVE_INFINITY)
                                )
                            )
                        )
                ) { }
                Box(modifier = modifier.padding(20.dp)) {
                    CustomButton(onClick = {}, title = "Play")
                }
            }
        }
    }
}