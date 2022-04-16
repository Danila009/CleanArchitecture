package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.viewModel.MusicViewModel
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ApiModule::class
    ]
)
@Singleton
interface AppComponent {
    fun musicViewModel():MusicViewModel
}