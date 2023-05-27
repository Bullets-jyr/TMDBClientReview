package kr.co.bullets.tmdbclientreview.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasource.MovieCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasourceImpl.TvShowCacheDatasourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataModule(): MovieCacheDatasource {
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataModule(): TvShowCacheDatasource {
        return TvShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataModule(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }
}