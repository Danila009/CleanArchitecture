package com.example.cleanarchitecture.presentation.ui.screen.musicScreen.state

import com.example.domain.entities.Music

data class MusicState(
    val isLoading: Boolean = false,
    val musics: List<Music> = emptyList(),
    val error: String = ""
)