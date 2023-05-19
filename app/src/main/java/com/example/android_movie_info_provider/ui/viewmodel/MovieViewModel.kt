package com.example.android_movie_info_provider.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.android_movie_info_provider.MyApplication
import com.example.android_movie_info_provider.data.models.DailyBoxOffice
import com.example.android_movie_info_provider.data.models.MovieModel
import com.example.android_movie_info_provider.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/// UI에서 상태 분기 목적으로 만듬
enum class MovieStatus {
    LOADING,
    SUCCESS,
    ERROR,
}

/// ViewModel에 들어갈 상태
data class MovieState(
    val status: MovieStatus = MovieStatus.LOADING,
    val dailyBoxOfficeModels: List<DailyBoxOffice> = listOf(),
    )

class MovieViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieState())
    val uiState : StateFlow<MovieState> = _uiState.asStateFlow()


    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])

                return MovieViewModel(
                    (application as MyApplication).movieRepository
                ) as T
            }
        }
    }
}