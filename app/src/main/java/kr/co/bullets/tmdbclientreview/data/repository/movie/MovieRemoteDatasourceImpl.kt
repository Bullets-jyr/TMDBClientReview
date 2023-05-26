package kr.co.bullets.tmdbclientreview.data.repository.movie

import kr.co.bullets.tmdbclientreview.data.api.TMDBService
import kr.co.bullets.tmdbclientreview.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}