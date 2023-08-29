package com.example.meditating.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditating.ui.theme.ButtonBlue
import com.example.meditating.ui.theme.DarkerButtonBlue
import com.example.meditating.ui.theme.DeepBlue
import com.example.meditating.ui.theme.LightRed
import com.example.meditating.ui.theme.TextWhite


val chips = listOf("Sweet Sleep", "Insomnia", "Depression")

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            MultipleChipSection(chips = chips)
            CurrentMeditation()
        }
    }
}


@Composable
fun GreetingSection(
    name: String = "Zinh Dragon"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello, $name",
                style = MaterialTheme.typography.headlineMedium,
                color = TextWhite
            )
            Text(
                text = "Have a good days",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
    }
}

@Composable
fun MultipleChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(
            count = chips.size
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable { selectedChipIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(
                    text = chips[it],
                    style = MaterialTheme.typography.bodySmall,
                    color = TextWhite
                )
            }
        }
    }
}


@Composable
fun CurrentMeditation(
    color: Color = LightRed,
    text: String = "Daily Thought",
    message: String = "Meditation",
) {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "Daily Thought",
                    style = MaterialTheme.typography.headlineMedium,
                    color = TextWhite
                )
                Text(
                    text = "Meditation . 3 - 10",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextWhite
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play Button",
                    tint = Color.White,
                    modifier = Modifier
                        .size(16.dp)
                )
            }
        }
    }
}


@Composable
fun FeatureSection(feature: List<Feature>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Features",
            color = TextWhite,
            style = MaterialTheme.typography.headlineMedium
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 7.5.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(feature.size){

            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(15.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(15.dp))
            .background(feature.darkColor)
    ) {

    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview(showBackground = true, backgroundColor = 4210752)
@Composable
fun GreetingSectionPreview() {
    GreetingSection()
}

@Preview
@Composable
fun ChipsSectionPreview() {
    MultipleChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression"))
}

@Preview
@Composable
fun CurrentMeditationPreview() {
    CurrentMeditation()
}

@Preview(showBackground = true, backgroundColor = 4210752)
@Composable
fun FeatureSectionPreview() {
    val feature_1 =
        Feature("Sleep Meditation", Icons.Default.Star, Color.White, Color.Gray, Color.Black)
    FeatureSection(feature = listOf(feature_1))
}

