package com.example.youtube_compose.ui.component.shorts

import android.util.Log
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@OptIn(UnstableApi::class) @Composable
fun ShortsPlayer(mediaUrl: String) {
    Log.d("[ShortsPlayer]", "ShortsPlayer() composition")

    /**
     * 기초 플레이어는 비율을 정하지 않고 비율을 파라미터로 받는 편이 좋다고 판단됨.
     * 추가적으로 자동실행을 위해서 최상위에 플레이어 하나를 두고 launched가 아닌 방향으로 하는 것이 좋다고 판단
     * 이를 위해서는 별도의 매니저를 두는 것이 좋아보임.
     * 별도의 전역 매니저에서 플레이어를 가지고 있고 매니저의 특정 함수를 url과 플레이어를 특징할 수 있는 무언가를 전달하여
     * 이어 받아 전달하는 방법이 어떤지 고민 중
     *
     * 자동 실행의 경우 launched Effect에서 대응하는 방식이 적합해 보임.
     */

    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaSource = remember(mediaUrl) {
        MediaItem.fromUri(mediaUrl)
    }


    // Set MediaSource to ExoPlayer
    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        exoPlayer.repeatMode = Player.REPEAT_MODE_ALL
    }

    // Manage lifecycle events
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    // Use AndroidView to embed an Android View (PlayerView) into Compose
    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
                controllerAutoShow = false
                controllerShowTimeoutMs = 500
            }
        },
        modifier = Modifier
            .fillMaxSize() // Set your desired height
    )
}