package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomChampTopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    title: @Composable () -> Unit,
    iconButton: @Composable () -> Unit
) {
    TopAppBar(
        modifier = modifier.padding(horizontal = 4.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color(0xffF3F2F3),
        ),
        title = {
            title()
        },
        navigationIcon = {
            IconButton(onClick = navController::popBackStack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go Back",
                    tint = Color(0xffF3F2F3)
                )
            }
        },
        actions = {
            iconButton()
        },
    )
}