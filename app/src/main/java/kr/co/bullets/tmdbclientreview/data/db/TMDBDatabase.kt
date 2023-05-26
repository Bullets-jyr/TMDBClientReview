package kr.co.bullets.tmdbclientreview.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.bullets.tmdbclientreview.data.model.artist.Artist
import kr.co.bullets.tmdbclientreview.data.model.movie.Movie
import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    // we need to define abstract functions to get dao interfaces
    abstract fun MovieDao(): MovieDao

    abstract fun TvShowDao(): TvShowDao

    abstract fun ArtistDao(): ArtistDao
}