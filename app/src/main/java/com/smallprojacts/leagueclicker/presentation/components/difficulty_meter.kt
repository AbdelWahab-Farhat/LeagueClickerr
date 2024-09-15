package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DifficultyMeter(modifier: Modifier = Modifier, level:Int) {
    val totalParallelograms = 3
    Row(modifier = modifier.padding(top = 5.dp)) {
        for (i in 1..totalParallelograms) {
            val color = if (i <= level) Color(0xffF3F2F3) else Color(0x77F3F2F3)
            ParallelogramShape(color)
        }
    }
}