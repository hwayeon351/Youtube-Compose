package com.example.youtube_compose.ui.component.common.bottomMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.youtube_compose.R
import com.example.youtube_compose.ui.component.common.text.SubText

enum class BottomMenuType(name: String, iconId: Int) {
    MENU_TYPE_1("menu1", R.drawable.logo),
    MENU_TYPE_2("menu2", R.drawable.logo),
    MENU_TYPE_3("menu3", R.drawable.logo),
    MENU_TYPE_4("menu4", R.drawable.logo),
    MENU_TYPE_5("menu5", R.drawable.logo)
}

@Composable
fun BottomMenu(type: BottomMenuType) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = type.name,
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
        )
        SubText(text = type.name)
    }
}