package com.example.youtube_compose.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.rememberNavController
import com.example.youtube_compose.ui.component.common.bar.BottomNavigationBar
import com.example.youtube_compose.ui.component.common.bar.NavigationGraph
import com.example.youtube_compose.ui.component.common.bar.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { TopBar(scrollBehavior = scrollBehavior) },
        bottomBar = { BottomNavigationBar(navController = navController) },
    ) { paddingValues ->
        NavigationGraph(navController = navController, paddingValues = paddingValues)
    }
}