package kr.co.bullets.tmdbclientreview.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.co.bullets.tmdbclientreview.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.GetTvShowsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModelFactory(private val getTvShowsUseCase: GetTvShowsUseCase, private val updateTvShowsUseCase: UpdateTvShowsUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}