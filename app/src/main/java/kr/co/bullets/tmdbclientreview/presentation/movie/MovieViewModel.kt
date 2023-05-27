package kr.co.bullets.tmdbclientreview.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.co.bullets.tmdbclientreview.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(private val getMoviesUseCase: GetMoviesUseCase, private val updateMoviesUseCase: UpdateMoviesUseCase) : ViewModel() {

    // this function will invoke execute function of the getMoviesUseCase and emit received list as livedata
    // since we are using coroutines, we will use a livedata block here
    // we are not explicitly provide any dispatcher here
    // so coroutine will use the main thread
    // since we have used IO thread in the datasources, calling them from the UI thread is the best practice
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}