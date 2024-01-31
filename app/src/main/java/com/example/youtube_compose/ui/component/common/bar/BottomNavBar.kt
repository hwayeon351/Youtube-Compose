package com.example.youtube_compose.ui.component.common.bar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.youtube_compose.R
import com.example.youtube_compose.ui.screen.HomeScreen
import com.example.youtube_compose.ui.screen.MakeScreen
import com.example.youtube_compose.ui.screen.MyPageScreen
import com.example.youtube_compose.ui.screen.ShortsScreen
import com.example.youtube_compose.ui.screen.SubscriptionsScreen

sealed class BottomNav(
    val title: String? = null,
    val route: String,
    val selectedIconRes: Int? = null,
    val unselectedIconRes: Int
) {
    data object Home :
        BottomNav("홈", BottomNavRoute.HOME, R.drawable.nav_home_sel, R.drawable.nav_home)

    data object Shorts :
        BottomNav("Shorts", BottomNavRoute.SHORTS, R.drawable.nav_shorts_sel, R.drawable.nav_shorts)

    data object Make :
        BottomNav(route = BottomNavRoute.MAKE, unselectedIconRes = R.drawable.nav_make)

    data object Subscriptions : BottomNav(
        "구독",
        BottomNavRoute.SUBSCRIPTIONS,
        R.drawable.nav_subscription_sel,
        R.drawable.nav_subscription
    )

    data object MyPage :
        BottomNav("나", BottomNavRoute.MYPAGE, R.drawable.nav_mypage_sel, R.drawable.nav_mypage)

    object BottomNavRoute {
        const val HOME = "HOME"
        const val SHORTS = "SHORTS"
        const val MAKE = "MAKE"
        const val SUBSCRIPTIONS = "SUBSCRIPTIONS"
        const val MYPAGE = "MYPAGE"
    }
}

val bottomNavItems = listOf(
    BottomNav.Home,
    BottomNav.Shorts,
    BottomNav.Make,
    BottomNav.Subscriptions,
    BottomNav.MyPage
)

@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = BottomNav.Home.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        composable(BottomNav.Home.route) {
            HomeScreen(navController = navController, paddingValues = paddingValues)
        }
        composable(BottomNav.Shorts.route) {
            ShortsScreen(navController = navController, paddingValues = paddingValues)
        }
        composable(BottomNav.Make.route) {
            MakeScreen(navController = navController, paddingValues = paddingValues)
        }
        composable(BottomNav.Subscriptions.route) {
            SubscriptionsScreen(navController = navController, paddingValues = paddingValues)
        }
        composable(BottomNav.MyPage.route) {
            MyPageScreen(navController = navController, paddingValues = paddingValues)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var currentRoute by remember { mutableStateOf(BottomNav.Home.route) }
    NavigationBar {
        bottomNavItems.forEach { nav ->
            NavigationBarItem(
                selected = currentRoute == nav.route,
                onClick = {
                    currentRoute = nav.route
                    navController.navigate(nav.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = nav.unselectedIconRes),
                        contentDescription = nav.title,
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                },
                label = { nav.title?.let { Text(text = it, fontSize = 9.sp) } },
            )
        }
    }
}