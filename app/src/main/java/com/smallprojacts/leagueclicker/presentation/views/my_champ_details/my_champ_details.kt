package com.smallprojacts.leagueclicker.presentation.views.my_champ_details

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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.smallprojacts.leagueclicker.data.api.AllMyEvents
import com.smallprojacts.leagueclicker.data.api.Champ
import com.smallprojacts.leagueclicker.presentation.components.AbilitySelector
import com.smallprojacts.leagueclicker.presentation.components.ChampionDetailsPicture
import com.smallprojacts.leagueclicker.presentation.components.CustomButton
import com.smallprojacts.leagueclicker.presentation.components.CustomChampTopBar
import com.smallprojacts.leagueclicker.presentation.components.StatMeterGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyChampScreen(
    modifier: Modifier = Modifier, navController: NavHostController,
    state: MyChampDetailsState,
    onEvent: (MyChampDetailsEvent) -> Unit,
    championId: Int
) {
    LaunchedEffect(key1 = Unit) {
//        ondynamicEvent(AllMyEvents.MyChampDetailsStateEvent(data = onEvent )).run {
//            onEvent(MyChampDetailsEvent.PageInit(championId))
//        }
        onEvent(MyChampDetailsEvent.PageInit(championId))
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
                CustomChampTopBar()
            },
            bottomBar = {
                Box(
                    modifier = modifier
                        .background(Color(0xff0A1428))
                        .padding(horizontal = 20.dp,).padding(top = 5.dp) .navigationBarsPadding()
                ) {
                    CustomButton(onClick = {}, title = "Play")
                }
            }

        ) { innerPadding ->
            val statList = mapOf(
                "Strength" to (state.champ.stats?.strength ?: 1),
                "Intelligence" to (state.champ.stats?.intelligence ?: 1),
                "Speed" to (state.champ.stats?.speed ?: 1),
                "Health" to (state.champ.stats?.health ?: 1),
                "Attack Damage" to (state.champ.stats?.attackDamage ?: 1),
                "Attack Power" to(state.champ.stats?.abilityPower ?: 1)
            )


            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
            ) {

                ChampionDetailsPicture(
                    modifier = modifier,
                   imagepath   = "${state.champ.championImage}",

                    name = "${state.champ.name}",
                    level = state.champ.stats?.strength?.plus(state.champ.stats?.health ?: 0)  ?: 0,
                    title = null,
                    numOfClicks = state.champ.numberOfClicks,
                )

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

                    StatMeterGrid(statMap = statList,state,onEvent)

                    Spacer(modifier = modifier.size(30.dp))

                    Text(
                        "Items & Skills",
                        color = Color(0xffF3F2F3),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

               AbilitySelector(modifier = modifier,state, onEvent = onEvent)
                Spacer(modifier =  Modifier.navigationBarsPadding().height(60.dp))

                Box(modifier = modifier.padding(20.dp)) {

                }
            }
        }
    }
}

