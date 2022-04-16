package com.example.cleanarchitecture.presentation.ui.screen.musicScreen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.domain.entities.Music

@Composable
fun MusicItemView(
    music: Music
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Image(
                painter = rememberImagePainter(data = music.webIcon),
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .size(150.dp)
            )
            Text(
                text = music.title,
                modifier = Modifier.padding(5.dp)
            )
        }
        Divider()
    }
}