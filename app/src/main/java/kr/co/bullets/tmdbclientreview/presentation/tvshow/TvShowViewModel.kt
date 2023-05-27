package kr.co.bullets.tmdbclientreview.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.co.bullets.tmdbclientreview.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.GetTvShowsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(private val getTvShowsUseCase: GetTvShowsUseCase, private val updateTvShowsUseCase: UpdateTvShowsUseCase) : ViewModel() {

    // this function will invoke execute function of the getMoviesUseCase and emit received list as livedata
    // since we are using coroutines, we will use a livedata block here
    // we are not explicitly provide any dispatcher here
    // so coroutine will use the main thread
    // since we have used IO thread in the datasources, calling them from the UI thread is the best practice
    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}