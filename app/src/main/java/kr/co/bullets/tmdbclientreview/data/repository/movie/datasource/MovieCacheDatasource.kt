package kr.co.bullets.tmdbclientreview.data.repository.movie.datasource

import kr.co.bullets.tmdbclientreview.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}