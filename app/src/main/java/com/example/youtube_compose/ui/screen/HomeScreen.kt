package com.example.youtube_compose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.youtube_compose.ui.component.main.HalfPlayer

@Composable
fun HomeScreen() {
    val lazyListState = rememberLazyListState()
    val list = listOf("test", "test", "test", "test", "test", "test", "test", "test", "test")

    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            items(list) {
                HalfPlayer()
            }
        }
    }
}