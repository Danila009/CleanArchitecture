package com.example.domain.use_case.getMusic

import com.example.domain.common.Resource
import com.example.domain.entities.Music
import com.example.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMusicUseCase @Inject constructor(
    private val repository: MusicRepository
) {
    operator fun invoke():Flow<Resource<List<Music>>> = flow {
        try {
            emit(Resource.Loading<List<Music>>())
            val music = repository.getMusic()
            emit(Resource.Success(music))
        }catch (e:Exception){
            emit(Resource.Error<List<Music>>(e.message.toString()))
        }
    }
}