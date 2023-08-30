package com.example.meditating.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.meditating.ui.theme.Beige1
import com.example.meditating.ui.theme.Beige2
import com.example.meditating.ui.theme.Beige3
import com.example.meditating.ui.theme.BlueViolet1
import com.example.meditating.ui.theme.BlueViolet2
import com.example.meditating.ui.theme.BlueViolet3
import com.example.meditating.ui.theme.LightGreen1
import com.example.meditating.ui.theme.LightGreen2
import com.example.meditating.ui.theme.LightGreen3
import com.example.meditating.ui.theme.OrangeYellow1
import com.example.meditating.ui.theme.OrangeYellow2
import com.example.meditating.ui.theme.OrangeYellow3

data class Feature(
    val title: String,
    val icon: ImageVector,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)

val FeatureList = listOf<Feature>(
    Feature(
        "Sleep Meditation",
        Icons.Default.Build,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    ),
    Feature(
        "Tips for Sleeping",
        Icons.Rounded.CheckCircle,
        LightGreen1,
        LightGreen2,
        LightGreen3
    ),
    Feature(
        "Night Island",
        Icons.Default.List,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3
    ),
    Feature(
        "Calming Sounds",
        Icons.Default.DateRange,
        Beige1,
        Beige2,
        Beige3
    ),
    Feature(
        "Raining",
        Icons.Default.DateRange,
        BlueViolet2,
        Beige3,
        OrangeYellow2
    ),
    Feature(
        "Deep Breaths",
        Icons.Default.DateRange,
        Beige1,
        LightGreen3,
        OrangeYellow3
    )
)