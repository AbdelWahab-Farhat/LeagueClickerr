package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun BottomNavBar(selectedItem: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(16.dp)
            .padding(
                bottom = WindowInsets.systemBars
                    .asPaddingValues()
                    .calculateBottomPadding()
            ),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(
            icon = Icons.Outlined.Notifications,
            contentDescription = "Notifications",
            isSelected = selectedItem == "Notifications"
        )
        BottomNavItem(
            icon = Icons.Outlined.Home,
            contentDescription = "Home",
            isSelected = selectedItem == "Home"
        )
        BottomNavItem(
            icon = Icons.Default.MoreVert,
            contentDescription = "Settings",
            isSelected = selectedItem == "Settings"
        )
    }
}

@Composable
fun BottomNavItem(icon: ImageVector, contentDescription: String, isSelected: Boolean) {
    val borderColor = Color.Transparent
    val fillColor = if (isSelected) Brush.linearGradient(
        colors = listOf(Color(0xff785A28), Color(0xffC89B3C)),

        ) else Brush.linearGradient(colors = listOf(Color.Transparent, Color.Transparent))

    val iconTint = Color.White

    Box(
        modifier = Modifier
            .width(64.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(20.dp))
            .border(2.dp, borderColor, RoundedCornerShape(20.dp))
            .background(
                fillColor
            ),
        contentAlignment = Alignment.Center,

        ) {
        IconButton(onClick = { }) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = iconTint
            )
        }
    }
}