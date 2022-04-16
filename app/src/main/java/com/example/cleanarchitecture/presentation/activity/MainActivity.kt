package com.example.cleanarchitecture.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cleanarchitecture.di.AppComponent
import com.example.cleanarchitecture.di.DaggerAppComponent
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.MusicScreen

class MainActivity : ComponentActivity() {

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent = DaggerAppComponent.create()
        setContent { MusicScreen(musicViewModel = appComponent.musicViewModel()) }
    }
}
