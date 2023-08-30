package com.example.meditating.ui

import android.widget.AdapterView.OnItemClickListener
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditating.standardQuadTo
import com.example.meditating.ui.theme.AquaBlue
import com.example.meditating.ui.theme.ButtonBlue
import com.example.meditating.ui.theme.DarkerButtonBlue
import com.example.meditating.ui.theme.DeepBlue
import com.example.meditating.ui.theme.LightRed
import com.example.meditating.ui.theme.TextWhite


val chips = listOf("Sweet Sleep", "Insomnia", "Depression")

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .background(DeepBlue)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
            ) {
                GreetingSection()
                MultipleChipSection(chips = chips)
                CurrentMeditation()
                FeatureSection(feature = FeatureList)
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ){
            BottomMenu(menuItems = BottomMenuList)
        }
    }


}


@Composable
fun GreetingSection(
    name: String = "VinhDev3006"
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 80.dp)
    ) {
        Text(
            text = "Features",
            color = TextWhite,
            style = MaterialTheme.typography.headlineMedium
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 7.5.dp),
        ) {
            items(feature.size){
                FeatureItem(feature = feature[it])
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
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val mediumColorPoint_1 = Offset(0f, height * 0.3f)
        val mediumColorPoint_2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColorPoint_3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColorPoint_4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColorPoint_5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColorPath = Path().apply {
            moveTo(mediumColorPoint_1.x, mediumColorPoint_1.y)
            standardQuadTo(mediumColorPoint_1, mediumColorPoint_2)
            standardQuadTo(mediumColorPoint_2, mediumColorPoint_3)
            standardQuadTo(mediumColorPoint_3, mediumColorPoint_4)
            standardQuadTo(mediumColorPoint_4, mediumColorPoint_5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }


        val lightColorPoint_1 = Offset(0f, height * 0.3f)
        val lightColorPoint_2 = Offset(width * 0.1f, height * 0.35f)
        val lightColorPoint_3 = Offset(width * 0.3f, height * 0.35f)
        val lightColorPoint_4 = Offset(width * 0.65f, height.toFloat())
        val lightColorPoint_5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColorPath = Path().apply {
            moveTo(lightColorPoint_1.x, lightColorPoint_1.y)
            standardQuadTo(lightColorPoint_1, lightColorPoint_2)
            standardQuadTo(lightColorPoint_2, lightColorPoint_3)
            standardQuadTo(lightColorPoint_3, lightColorPoint_4)
            standardQuadTo(lightColorPoint_4, lightColorPoint_5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }


        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColorPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColorPath ,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.titleMedium,
                lineHeight = 26.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth()
            ){
                Icon(
                    imageVector = feature.icon,
                    contentDescription = feature.title,
                    tint = Color.White,
                )

                Button(
                    border = BorderStroke(3.dp, Color.White),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                    ,
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Start",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,

                        )
                }
            }

        }
    }
}


@Composable
fun BottomMenu(
    menuItems: List<BottomMenuContent>,
    highlightedColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
){
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        menuItems.forEachIndexed { index, bottomMenuItem ->
            BottomMenuItem(
                content = bottomMenuItem,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = highlightedColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}


@Composable
fun BottomMenuItem(
    content: BottomMenuContent,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onItemClick }
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                imageVector = content.icon,
                contentDescription = "Menu Item Icon",
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = content.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
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
    FeatureSection(feature = FeatureList)
}

@Preview
@Composable
fun BottomMenuPreview(){
    BottomMenu(menuItems = BottomMenuList)
}
