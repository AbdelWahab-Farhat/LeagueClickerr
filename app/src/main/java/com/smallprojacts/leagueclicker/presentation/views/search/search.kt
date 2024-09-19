package com.smallprojacts.leagueclicker.presentation.views.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.presentation.components.CustomChampTopBar
import com.smallprojacts.leagueclicker.presentation.components.CustomTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    Scaffold(
        modifier = modifier.background(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xff091428), Color(0xff0A1428)),
                start = Offset(0f, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        ),
        containerColor = Color.Transparent,
        topBar = {
            Column(
                modifier = modifier.background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xff091428), Color(0xff0A1428)),
                        start = Offset(0f, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomChampTopBar(navController = navController)
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                ) {
                    CustomTextField(label = null, placeholder = {
                        Text(
                            text = "Search", color = Color.White
                        )
                    }, suffexicon = {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                                tint = Color.White,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Search Icon",
                                tint = Color.White,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        }
                    })
                }
            }

        },
    ) { innerPadding ->
        val stats = mapOf(
            "Strength" to 1,
            "Intelligence" to 5,
            "Speed" to 3,
            "Health" to 2,
            "Attack Damage" to 4,
            "safas" to 1,
            ";kga" to 1,
            "p9ipwt" to 1,
            "gkasg;" to 1,
            "ask" to 1,
        )
//        ChampionGrid(
//            modifier = Modifier
//                .padding(innerPadding)
//                .padding(horizontal = 20.dp),
//            champs = c,
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
//                .padding(innerPadding)
//                .padding(start = 20.dp, end = 20.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Box() {
//                Image(
//                    painterResource(R.drawable.poro),
//                    "No Champions Found.",
//                    alignment = Alignment.Center,
//                    contentScale = ContentScale.Crop,
//                    modifier = modifier
//                        .shadow(
//                            elevation = 100.dp,
//                            shape = CircleShape,
//                            spotColor = Color(0xff0397AB)
//                        )
//                        .size(300.dp)
//                )
//            }
//            Text(
//                text = "Oops I Ate All The Champions",
//                fontSize = 28.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xDDF3F2F3)
//            )
//
//        }
    }
}
