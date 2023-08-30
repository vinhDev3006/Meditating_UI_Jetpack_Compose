package com.example.meditating.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomMenuContent(
    val icon: ImageVector,
    val title: String
)



val BottomMenuList = listOf<BottomMenuContent>(
    BottomMenuContent(
        icon = Icons.Default.AddCircle,
        title = "Home"
    ),
    BottomMenuContent(
        icon = Icons.Default.AddCircle,
        title = "Meditate"
    ),
    BottomMenuContent(
        icon = Icons.Default.AddCircle,
        title = "Sleep"
    ),
    BottomMenuContent(
        icon = Icons.Default.AddCircle,
        title = "Music"
    ),
    BottomMenuContent(
        icon = Icons.Default.AddCircle,
        title = "Profile"
    ),

)
