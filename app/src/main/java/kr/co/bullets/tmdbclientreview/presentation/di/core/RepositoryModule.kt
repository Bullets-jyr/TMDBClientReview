package kr.co.bullets.tmdbclientreview.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.data.repository.artist.ArtistRepositoryImpl
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistRemoteDatasource
import kr.co.bullets.tmdbclientreview.data.repository.movie.MovieRepositoryImpl
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasource.MovieCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasource.MovieLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.movie.datasource.MovieRemoteDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.TvShowRepositoryImpl
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowRemoteDatasource
import kr.co.bullets.tmdbclientreview.domain.repository.ArtistRepository
import kr.co.bullets.tmdbclientreview.domain.repository.MovieRepository
import kr.co.bullets.tmdbclientreview.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDatasource: MovieRemoteDatasource, movieLocalDatasource: MovieLocalDatasource, movieCacheDatasource: MovieCacheDatasource): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDatasource, movieLocalDatasource, movieCacheDatasource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(tvShowRemoteDatasource: TvShowRemoteDatasource, tvShowLocalDatasource: TvShowLocalDatasource, tvShowCacheDatasource: TvShowCacheDatasource): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDatasource, tvShowLocalDatasource, tvShowCacheDatasource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(artistRemoteDatasource: ArtistRemoteDatasource, artistLocalDatasource: ArtistLocalDatasource, artistCacheDatasource: ArtistCacheDatasource): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDatasource, artistLocalDatasource, artistCacheDatasource)
    }
}