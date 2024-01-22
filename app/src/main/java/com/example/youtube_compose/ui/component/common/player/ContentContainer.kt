package com.example.youtube_compose.ui.component.common.player

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.youtube_compose.R
import com.example.youtube_compose.ui.component.common.text.MainText
import com.example.youtube_compose.ui.component.common.text.SubText

@Composable
fun ContentContainer() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
    ) {
        val logo = painterResource(id = R.drawable.logo)
        Image(
            painter = logo,
            contentDescription = "썸네일",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .aspectRatio(1f / 1f)
                .padding(5.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(5.dp)
        ) {
            MainText(text = "Making Orange Juice")
            SubText(text = "orange · 조회수 423만회 · 1년 전")
        }
    }
}