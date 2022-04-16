package com.example.data.repository

import com.example.data.remote.MusicApi
import com.example.domain.entities.Music
import com.example.domain.repository.MusicRepository
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val api:MusicApi
): MusicRepository {
    override suspend fun getMusic(): List<Music> {
        val music = api.getMusic().body()
        return music ?: emptyList()
    }
}