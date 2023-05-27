package kr.co.bullets.tmdbclientreview.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.data.api.TMDBService
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistRemoteDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasource.MovieRemoteDatasource
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowRemoteDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(tmdbService, apiKey)
    }
}