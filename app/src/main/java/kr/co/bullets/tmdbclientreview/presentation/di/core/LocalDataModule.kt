package kr.co.bullets.tmdbclientreview.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.data.db.ArtistDao
import kr.co.bullets.tmdbclientreview.data.db.MovieDao
import kr.co.bullets.tmdbclientreview.data.db.TvShowDao
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasource.MovieLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDatasource {
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDatasource {
        return TvShowLocalDatasourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDatasource {
        return ArtistLocalDatasourceImpl(artistDao)
    }
}