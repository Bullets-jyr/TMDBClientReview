package kr.co.bullets.tmdbclientreview.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.domain.repository.ArtistRepository
import kr.co.bullets.tmdbclientreview.domain.repository.MovieRepository
import kr.co.bullets.tmdbclientreview.domain.repository.TvShowRepository
import kr.co.bullets.tmdbclientreview.domain.usecase.GetArtistsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.GetTvShowsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateArtistsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateMoviesUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateTvShowsUseCase
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }
}