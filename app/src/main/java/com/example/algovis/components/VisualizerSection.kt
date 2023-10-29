package com.example.algovis.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max

@Composable
fun VisualizerSection(
    modifier: Modifier = Modifier,
    arr : IntArray
){
    BoxWithConstraints (modifier = modifier) {
        val maxHeight = remember {
            maxHeight - 75.dp
        }
        val itemWidth = remember {
            maxWidth / arr.size - 1.dp
        }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        )
        {
            arr.forEach {
                Box(
                    modifier = Modifier
                        .height(if (it.dp > maxHeight) maxHeight else it.dp)
                        .width(itemWidth)
                        .background(Color.White)
                )
            }
        }
    }
}