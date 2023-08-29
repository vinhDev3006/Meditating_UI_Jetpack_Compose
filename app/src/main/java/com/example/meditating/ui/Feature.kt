package com.example.meditating.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Feature(
    val title: String,
    val icon: ImageVector,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
