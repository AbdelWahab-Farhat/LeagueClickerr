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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.Send
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.material.icons.twotone.Face
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BottomNavBar(operation: (Int) -> Unit, selectItem: Int) {

    val items = listOf("My Champs", "Home", "All Champs")

    NavigationBar(
        containerColor = Color(0xff0A1428),
        tonalElevation = 0.dp,
        modifier = Modifier
            .shadow(elevation = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        when (item) {
                            "My Champs" -> Icon(
                                Icons.AutoMirrored.TwoTone.Send,
                                contentDescription = item,
                                tint = Color.White,
                                modifier = Modifier.size(35.dp)
                            )

                            "All Champs" -> Icon(
                                Icons.TwoTone.DateRange,
                                contentDescription = item,
                                tint = Color.White,
                                modifier = Modifier.size(35.dp)
                            )

                            "Home" -> Icon(
                                Icons.TwoTone.Home,
                                contentDescription = item,
                                tint = Color.White,
                                modifier = Modifier.size(35.dp)
                            )
                        }
                    },
                    label = { Text(item, color = Color.White, fontSize = 16.sp) },
                    selected = selectItem == index,
                    onClick = { operation(index) },
                    modifier = Modifier
                        .padding(0.dp)
                        .size(width = 140.dp, height = 50.dp),
                )
            }
        }
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