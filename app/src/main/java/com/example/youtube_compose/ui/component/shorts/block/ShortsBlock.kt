package com.example.youtube_compose.ui.component.shorts.block

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShortsBlock() {
    val lazyListState = rememberLazyListState()
    val list = listOf(
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        )

    var focusItemPosition by remember { mutableIntStateOf(-1) }

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        ShortsBlockHeader()
        LazyRow(
            state = lazyListState,
            contentPadding = PaddingValues(10.dp, 10.dp, 0.dp, 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            itemsIndexed(list) { position, url ->
                ShortsBlockItem(url, position == focusItemPosition) {
                    focusItemPosition = position
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}