package kr.co.bullets.tmdbclientreview.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.data.db.ArtistDao
import kr.co.bullets.tmdbclientreview.data.db.MovieDao
import kr.co.bullets.tmdbclientreview.data.db.TMDBDatabase
import kr.co.bullets.tmdbclientreview.data.db.TvShowDao
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, name = "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.MovieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.TvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.ArtistDao()
    }
}