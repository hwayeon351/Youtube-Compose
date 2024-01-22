package com.example.youtube_compose.ui.component.common.player

import android.util.Log
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

const val EXAMPLE_VIDEO_URI = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

@Composable
fun Player() {
//    val thumbnail = painterResource(id = R.drawable.thumb)
//    Image(
//        painter = thumbnail,
//        contentDescription = "썸네일",
//        modifier = Modifier
//            .fillMaxWidth()
//            .aspectRatio(16f / 9f)
//            .clip(RoundedCornerShape(10.dp))
//    )

    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaSource = remember(EXAMPLE_VIDEO_URI) {
        MediaItem.fromUri(EXAMPLE_VIDEO_URI)
    }

    // Set MediaSource to ExoPlayer
    LaunchedEffect(mediaSource) {
        Log.d("test", "Tetststs")
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
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
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .clip(RoundedCornerShape(10.dp)) // Set your desired height
    )
}
