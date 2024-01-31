package com.example.youtube_compose.ui.component.common.bar

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.youtube_compose.R
import com.example.youtube_compose.ui.screen.HomeScreen
import com.example.youtube_compose.ui.screen.MakeScreen
import com.example.youtube_compose.ui.screen.MyPageScreen
import com.example.youtube_compose.ui.screen.ShortsScreen
import com.example.youtube_compose.ui.screen.SubscriptionsScreen

sealed class BottomNav(
    val title: String? = null,
    val route: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
) {
    data object Home :
        BottomNav("홈", BottomNavRoute.HOME, R.drawable.baseline_home_24, R.drawable.outline_home_24)

    data object Shorts :
        BottomNav(
            "Shorts",
            BottomNavRoute.SHORTS,
            R.drawable.baseline_smart_display_24,
            R.drawable.outline_smart_display_24
        )

    data object Make :
        BottomNav(
            route = BottomNavRoute.MAKE,
            selectedIcon = R.drawable.outline_add_circle_outline_24,
            unselectedIcon = R.drawable.outline_add_circle_outline_24
        )

    data object Subscriptions : BottomNav(
        "구독",
        BottomNavRoute.SUBSCRIPTIONS,
        R.drawable.baseline_subscriptions_24,
        R.drawable.outline_subscriptions_24
    )

    data object MyPage :
        BottomNav(
            "나",
            BottomNavRoute.MYPAGE,
            R.drawable.baseline_account_circle_24,
            R.drawable.outline_account_circle_24
        )

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
            HomeScreen()
        }
        composable(BottomNav.Shorts.route) {
            ShortsScreen()
        }
        composable(BottomNav.Make.route) {
            MakeScreen()
        }
        composable(BottomNav.Subscriptions.route) {
            SubscriptionsScreen()
        }
        composable(BottomNav.MyPage.route) {
            MyPageScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var currentRoute by remember { mutableStateOf(BottomNav.Home.route) }
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        NavigationBar(containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White) {
            bottomNavItems.forEach { nav ->
                val selected = currentRoute == nav.route
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        currentRoute = nav.route
                        navController.navigate(nav.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = if (selected) nav.selectedIcon else nav.unselectedIcon),
                            contentDescription = nav.title
                        )
                    },
                    label = { nav.title?.let { Text(text = it, fontSize = 9.sp) } },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
                        selectedIconColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unselectedIconColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        selectedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unselectedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                    )
                )
            }
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

@Preview(name = "Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewBottomNavigationBar() {
    val navController = rememberNavController()
    BottomNavigationBar(navController = navController)
}