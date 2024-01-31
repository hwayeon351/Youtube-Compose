package com.example.youtube_compose.ui.component.shorts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortsMain() {
    val list = listOf(
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
        "https://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
    )
    val pagerState = rememberPagerState(pageCount = {
        list.size
    })

    VerticalPager(state = pagerState) {
        ShortsItem(list[it])
    }
}