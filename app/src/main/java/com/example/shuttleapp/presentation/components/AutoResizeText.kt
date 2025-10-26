package com.example.shuttleapp.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


@Composable
fun AutoResizeText(
    text: String,
    fontSize: TextUnit = 24.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    fontStyle: FontStyle? = null,
    modifier: Modifier = Modifier,
    colors: Color = MaterialTheme.colorScheme.onBackground
) {
    var textSize by remember { mutableStateOf(fontSize) }
    var readyToDraw by remember { mutableStateOf(false) }

    Text(
        text = text,
        fontSize = textSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        modifier = modifier,//.alpha(if(readyToDraw)1f else 0f), //,
        color = colors,
        maxLines = 1,
        overflow = TextOverflow.MiddleEllipsis,

        )
//    BasicText(
//        text = text,
//        style = TextStyle(
//            color = colors,
//            fontSize = fontSize,
//            fontWeight = fontWeight,
//            fontStyle = fontStyle,
//            fontFamily = FontFamily.SansSerif
//        ),
//        overflow = TextOverflow.MiddleEllipsis,
//        autoSize = TextAutoSize.StepBased(
//            stepSize = 0.25.sp
//        ),
//        maxLines = 1,
//        modifier = modifier,
////        color = {
////            colors
////        }
//    )
}