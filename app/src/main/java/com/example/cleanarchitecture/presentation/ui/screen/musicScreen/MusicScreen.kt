package com.example.cleanarchitecture.presentation.ui.screen.musicScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.state.MusicState
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.state.MusicViewState
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.view.MusicErrorView
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.view.MusicItemView
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.view.MusicLoadingView
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.viewModel.MusicViewModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MusicScreen(
    lifecycleScope:LifecycleCoroutineScope = LocalLifecycleOwner.current.lifecycleScope,
    lifecycle:Lifecycle = LocalLifecycleOwner.current.lifecycle,
    musicViewModel: MusicViewModel
) {
    var musicState by remember { mutableStateOf(MusicState()) }

    LaunchedEffect(key1 = Unit, block = {
        musicViewModel.reduce(
            state = MusicViewState.GetMusic
        )
    })

    lifecycleScope.launch {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
            musicViewModel.responseMusic.collect{ resource ->
                musicState = resource
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        LazyColumn(content = {
            items(musicState.musics) { item -> MusicItemView(music = item) }
        })

        if (musicState.error.isNotBlank()){ MusicErrorView(message = musicState.error) }

        if (musicState.isLoading){ MusicLoadingView() }
    }
}