package com.example.youtube_compose.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.youtube_compose.ui.component.shorts.ShortsMain

@Composable
fun ShortsScreen(navController: NavController, paddingValues: PaddingValues) {
    ShortsMain()
}