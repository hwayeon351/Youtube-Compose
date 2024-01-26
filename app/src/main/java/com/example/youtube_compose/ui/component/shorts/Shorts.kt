package com.example.youtube_compose.ui.component.shorts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.youtube_compose.R

@Composable
fun Shorts() {
    val lazyListState = rememberLazyListState()
    val list = listOf("test","test","test","test","test","test","test","test","test")

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        ShortsHeader()
        LazyRow(
            state = lazyListState,
            contentPadding = PaddingValues(10.dp, 10.dp, 0.dp, 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.White)
        ) {
            items(list) {
                ShortsBlock()
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}