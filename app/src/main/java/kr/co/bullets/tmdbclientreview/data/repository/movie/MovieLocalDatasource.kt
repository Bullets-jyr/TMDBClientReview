package kr.co.bullets.tmdbclientreview.data.repository.movie

import kr.co.bullets.tmdbclientreview.data.model.movie.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)

    suspend fun clearAll()
}