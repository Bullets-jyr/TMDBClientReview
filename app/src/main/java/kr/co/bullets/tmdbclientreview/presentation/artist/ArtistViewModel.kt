package kr.co.bullets.tmdbclientreview.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.co.bullets.tmdbclientreview.domain.usecase.GetArtistsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateArtistsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateMoviesUseCase

class ArtistViewModel(private val getArtistsUseCase: GetArtistsUseCase, private val updateArtistsUseCase: UpdateArtistsUseCase) : ViewModel() {

    // this function will invoke execute function of the getMoviesUseCase and emit received list as livedata
    // since we are using coroutines, we will use a livedata block here
    // we are not explicitly provide any dispatcher here
    // so coroutine will use the main thread
    // since we have used IO thread in the datasources, calling them from the UI thread is the best practice
    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}