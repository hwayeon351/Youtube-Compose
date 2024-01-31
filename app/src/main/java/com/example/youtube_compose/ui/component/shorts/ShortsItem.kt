package com.example.youtube_compose.ui.component.shorts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.youtube_compose.R

@Composable
fun ShortsItem(mediaUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
    ) {
        ShortsPlayer(mediaUrl = mediaUrl)
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {

        }
        IconButton(
            onClick = { /* do something */ },
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopEnd)
                .size(30.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                tint = Color.White,
                contentDescription = "Localized description"
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
        ) {
            ShortsInfo()
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            ShortsButtons()
        }
    }
}

@Composable
fun ShortsInfo() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Text(
            text = "shorts title shorts title",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "StreamerProfileImage",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "@streamerName",
                color = Color.White,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(5.dp))
            Button(
                onClick = { /* do something */ },
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                modifier = Modifier
                    .height(25.dp)
                    .wrapContentWidth()
            ) {
                Text(
                    text = "구독",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
    }
}

enum class ShortsIconType(val title: String, val offResId: Int, val onResId: Int? = null) {
    LIKE("좋아요", R.drawable.logo, R.drawable.logo),
    DISLIKE("싫어요", R.drawable.logo, R.drawable.logo),
    COMMENT("댓글", R.drawable.logo),
    SHARE("공유", R.drawable.logo),
    REMIX("리믹스", R.drawable.logo),
    GENRE("", R.drawable.logo)
}
@Composable
fun ShortsButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
    ) {
        for (item in ShortsIconType.entries) {
            ShortsIcon(type = item)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun ShortsIcon(type: ShortsIconType) {
    val isSeleted = remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
    ) {
        Image(
            painter = painterResource(id = if (isSeleted.value) type.onResId ?: type.offResId else type.offResId),
            contentDescription = type.title,
            modifier = Modifier.size(30.dp)
        )
        if (!type.title.isNullOrBlank()) {
            Text(
                text = type.title,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}