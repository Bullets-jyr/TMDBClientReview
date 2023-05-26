package kr.co.bullets.tmdbclientreview.domain.repository

import kr.co.bullets.tmdbclientreview.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}