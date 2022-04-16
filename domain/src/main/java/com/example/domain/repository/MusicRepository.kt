package com.example.domain.repository

import com.example.domain.entities.Music

interface MusicRepository {
    suspend fun getMusic():List<Music>
}