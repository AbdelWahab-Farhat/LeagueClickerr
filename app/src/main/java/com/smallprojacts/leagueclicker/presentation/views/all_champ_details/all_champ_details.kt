package com.smallprojacts.leagueclicker.presentation.views.all_champ_details

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.smallprojacts.leagueclicker.presentation.components.AbilitySelector
import com.smallprojacts.leagueclicker.presentation.components.BottomNavBar
import com.smallprojacts.leagueclicker.presentation.components.ChampionDetailsPicture
import com.smallprojacts.leagueclicker.presentation.components.ClassAndDifficulty
import com.smallprojacts.leagueclicker.presentation.components.CustomButton
import com.smallprojacts.leagueclicker.presentation.components.CustomChampTopBar
import com.smallprojacts.leagueclicker.presentation.components.DifficultyMeter
import com.smallprojacts.leagueclicker.presentation.components.StatMeterGrid
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllChampDetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    state: AllChampDetailsState,
    onEvent: (AllChampDetailsEvent) -> Unit,
    championId: Int
) {
    LaunchedEffect(key1 = Unit) {
        onEvent(AllChampDetailsEvent.PageInit(championId))
    }
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
                CustomChampTopBar(
                    navController = navController,
                    title = {},
                    iconButton = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.FilterAlt,
                                contentDescription = "Show 3d Model",
                                tint = Color(0xffF3F2F3)
                            )
                        }
                    })
            },
            bottomBar = {
                    Box(
                        modifier = modifier
                            .background(Color(0xff0A1428))
                            .padding(horizontal = 20.dp,).padding(top = 5.dp) .navigationBarsPadding()
                    ) {
                        CustomButton(onClick = {}, title = "Add Champion")
                    }
            }
        ) { innerPadding ->
            Column(
                modifier = modifier.verticalScroll(rememberScrollState())
            ) {

                ChampionDetailsPicture(
                    modifier = modifier,
                    imagepath = "${state.champ.championImage}",
                    name = "${state.champ.name ?: ""} ",
                    title = "${state.champ.title}",
                    level = null,
                    numOfClicks = null
                )

                Column(
                    modifier = modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp),
                ) {
                    Text(
                        "${state.champ.abilities.getOrNull(0)?.description ?: "No ability description available"} ",
                        color = Color(0xffF3F2F3),
                        fontSize = 16.sp
                    )

                    Spacer(modifier = modifier.size(30.dp))

                    Text(
                        "Items & Skills",
                        color = Color(0xffF3F2F3),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

                AbilitySelector(modifier = modifier,state = state,onEvent = onEvent)
                ClassAndDifficulty(champClass = state.champ.legacy?.type ?: "No Class", difficulty = 1)
                Spacer(modifier =  Modifier.navigationBarsPadding().height(60.dp))

            }
        }
    }
}