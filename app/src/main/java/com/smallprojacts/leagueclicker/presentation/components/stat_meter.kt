package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatMeterGrid(statMap: Map<String, Int>) {
    val itemsPerRow = 2
    val statList = statMap.toList().chunked(itemsPerRow)
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        statList.forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                rowItems.forEach { (stat, value) ->
                    StateMeter(stat = stat, level = value)
                }
            }
        }
    }
}

@Composable
fun StateMeter(modifier: Modifier = Modifier, stat: String, level: Int) {
    val totalParallelograms = 5
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = stat, color = Color(0xffF3F2F3), fontSize = 16.sp)
        Row(modifier = modifier.padding(top = 5.dp)) {
            for (i in 1..totalParallelograms) {
                val color = if (i <= level) Color(0xffF3F2F3) else Color(0x77F3F2F3)
                ParallelogramShape(color)
            }
        }
    }
}

