package com.example.cleanarchitecture.presentation.ui.screen.musicScreen.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MusicErrorView(
    message:String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Error: $message",
                modifier = Modifier.padding(5.dp)
            )

        }
    }
}