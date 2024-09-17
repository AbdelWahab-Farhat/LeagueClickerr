package com.smallprojacts.leagueclicker.presentation.views.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.presentation.components.BottomNavBar
import com.smallprojacts.leagueclicker.presentation.components.ProfileNav
import com.smallprojacts.leagueclicker.presentation.views.all_champs.AllChampView
import com.smallprojacts.leagueclicker.presentation.views.my_all_champs.MyAllChampView
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { 3 })
    var selectedItem by remember { mutableIntStateOf(0) }

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
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff0A1428),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { ProfileNav() }
            )
        },
        bottomBar = {
            BottomNavBar(
                { index ->
                    selectedItem = index
                    scope.launch { pagerState.animateScrollToPage(index) }
                },
                selectedItem
            )
        },

        ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> MyAllChampView(navController = navController, innerPadding = innerPadding)
//                    1 -> Home()
                2 -> AllChampView(navController = navController, innerPadding = innerPadding)
            }
        }

        LaunchedEffect(pagerState.currentPage) {
            selectedItem = pagerState.currentPage
        }
    }
}


