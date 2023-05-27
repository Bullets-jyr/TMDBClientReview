package kr.co.bullets.tmdbclientreview.presentation.di.movie

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateMoviesUseCase
import kr.co.bullets.tmdbclientreview.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase, updateMoviesUseCase: UpdateMoviesUseCase): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}