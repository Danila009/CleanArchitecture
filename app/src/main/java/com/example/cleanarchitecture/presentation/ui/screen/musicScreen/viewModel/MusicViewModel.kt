package com.example.cleanarchitecture.presentation.ui.screen.musicScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.state.MusicState
import com.example.cleanarchitecture.presentation.ui.screen.musicScreen.state.MusicViewState
import com.example.domain.common.Resource
import com.example.domain.use_case.getMusic.GetMusicUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MusicViewModel @Inject constructor(
    private val getMusicUseCase: GetMusicUseCase
):ViewModel() {

    private val _responseMusic:MutableStateFlow<MusicState> =
        MutableStateFlow(MusicState())
    val responseMusic:StateFlow<MusicState> = _responseMusic.asStateFlow()

    fun reduce(state: MusicViewState){
        when(state){
            MusicViewState.GetMusic -> getMusic()
        }
    }

    private fun getMusic(){
        getMusicUseCase().onEach { result ->
            when(result){
                is Resource.Error -> _responseMusic.value =
                    MusicState(error = result.message ?: "Error get music")
                is Resource.Loading -> _responseMusic.value =
                    MusicState(isLoading = true)
                is Resource.Success -> _responseMusic.value =
                    MusicState(musics = result.data ?: emptyList())
            }
        }.launchIn(viewModelScope)
    }
}