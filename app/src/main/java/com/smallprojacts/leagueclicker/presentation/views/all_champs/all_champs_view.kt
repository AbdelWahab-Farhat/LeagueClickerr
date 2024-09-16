package com.smallprojacts.leagueclicker.presentation.views.all_champs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.R
import com.smallprojacts.leagueclicker.presentation.components.BottomNavBar
import com.smallprojacts.leagueclicker.presentation.components.ChampionsColumn
import com.smallprojacts.leagueclicker.presentation.components.CustomTextField
import com.smallprojacts.leagueclicker.presentation.components.ProfileNav
import com.smallprojacts.leagueclicker.presentation.components.RuneterraRegions

@Composable
fun AllChampView(modifier: Modifier = Modifier, navController: NavHostController) {
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
            bottomBar = {
                BottomNavBar("Home")
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .padding(16.dp, 0.dp)
            ) {
                ProfileNav()
                CustomTextField(
                    placeholder = {
                        Text(
                            text = "Search",
                            color = Color.White
                        )
                    },
                    suffexicon =
                    {
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
                    }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Runeterra",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                RuneterraRegions(modifier)
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Champions",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                ChampionsColumn(modifier)

            }
        }
    }
}
