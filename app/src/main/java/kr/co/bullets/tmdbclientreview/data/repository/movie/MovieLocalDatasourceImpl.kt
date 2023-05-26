package kr.co.bullets.tmdbclientreview.data.repository.movie

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.bullets.tmdbclientreview.data.db.MovieDao
import kr.co.bullets.tmdbclientreview.data.model.movie.Movie

class MovieLocalDatasourceImpl(private val movieDao: MovieDao) : MovieLocalDatasource {
    // when we are getting data from the room database, room execute that query in a background thread
    // so we don't need to explicitly write codes for background processing
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    // but, we need to invoke other dao functions from a background thread
    // we will use coroutines for that
    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        // to run this in a background worker thread, using Dispatcher.IO
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}