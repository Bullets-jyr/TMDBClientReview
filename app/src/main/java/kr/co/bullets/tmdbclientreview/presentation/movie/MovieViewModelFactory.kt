package kr.co.bullets.tmdbclientreview.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.co.bullets.tmdbclientreview.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(private val getMoviesUseCase: GetMoviesUseCase, private val updateMoviesUseCase: UpdateMoviesUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}