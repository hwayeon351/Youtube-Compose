package com.example.youtube_compose.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.youtube_compose.ui.component.shorts.block.ShortsBlock

@Composable
fun SubscriptionsScreen(navController: NavController, paddingValues: PaddingValues) {
    ShortsBlock()
}