package com.example.youtube_compose.ui.component.shorts.block

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.youtube_compose.R

@Composable
fun ShortsBlockItem(mediaUrl: String, isFocus: Boolean, onClick: () -> Unit) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(9f / 16f)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                onClick()
            }
    ) {
        if (isFocus) {
            ShortsBlockPlayer(mediaUrl)
        } else {
            Image(
                painter = painterResource(id = R.drawable.image_default_shorts_thumbnail),
                contentDescription = "썸네일",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
        IconButton(
            onClick = { /* do something */ },
            modifier = Modifier
                .height(30.dp)
                .width(24.dp)
                .padding(5.dp, 8.dp)
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                tint = Color.White,
                contentDescription = "Localized description"
            )
        }
        Column(
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.BottomStart)
        ) {
            /**
             * 텍스트의 경우 생각보다 몇가지의 틀로 정의하기가 상당히 어렵다고 판단됨.
             * 이에 기초적인 분류를 나누는 기조는 그대로 가되 파라미터를 어느정도는 받을 수 있도록 수정하는 방향이 바람직하다고 봄
             */
            Text(
                text = "shorts title title 2 line test",
                color = Color.White,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "334K views",
                color = Color.White,
                fontSize = 10.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}