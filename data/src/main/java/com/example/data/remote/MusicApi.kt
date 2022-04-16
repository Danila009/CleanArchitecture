package com.example.data.remote

import com.example.data.common.ConstantsUrlApi.MUSIC_URL
import com.example.domain.entities.Music
import retrofit2.Response
import retrofit2.http.GET

interface MusicApi {
    @GET(MUSIC_URL)
    suspend fun getMusic():Response<List<Music>>
}