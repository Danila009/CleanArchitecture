package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.common.Constants.BASE_URL
import com.example.data.remote.MusicApi
import com.example.data.repository.MusicRepositoryImpl
import com.example.domain.repository.MusicRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object ApiModule {

    @Provides
    @Singleton
    fun providerMusicApi():MusicApi = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MusicApi::class.java)

    @Provides
    @Singleton
    fun providerMusicRepository(
        musicApi: MusicApi
    ):MusicRepository = MusicRepositoryImpl(musicApi)
}