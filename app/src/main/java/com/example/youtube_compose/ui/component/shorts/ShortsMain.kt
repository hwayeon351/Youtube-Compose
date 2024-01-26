package com.example.youtube_compose.ui.component.shorts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortsMain() {
    val pagerState = rememberPagerState(pageCount = {
        10
    })

    VerticalPager(state = pagerState) {
        ShortsItem()
    }
}