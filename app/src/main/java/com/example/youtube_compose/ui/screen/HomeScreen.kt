package com.example.youtube_compose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.youtube_compose.ui.component.main.HalfPlayer

@Composable
fun HomeScreen(navController: NavController, paddingValues: PaddingValues) {
    val lazyListState = rememberLazyListState()
    val list = listOf("test", "test", "test", "test", "test", "test", "test", "test", "test")

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
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