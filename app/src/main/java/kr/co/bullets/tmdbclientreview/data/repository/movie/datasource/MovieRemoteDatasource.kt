package kr.co.bullets.tmdbclientreview.data.repository.movie.datasource

import kr.co.bullets.tmdbclientreview.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}