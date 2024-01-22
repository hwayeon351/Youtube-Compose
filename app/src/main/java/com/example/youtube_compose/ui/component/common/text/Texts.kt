package com.example.youtube_compose.ui.component.common.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Title(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}

@Composable
fun MainText(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}

@Composable
fun SubText(text: String) {
    Text(
        text = text,
        color = Color.Gray,
        fontSize = 12.sp,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
    )
}