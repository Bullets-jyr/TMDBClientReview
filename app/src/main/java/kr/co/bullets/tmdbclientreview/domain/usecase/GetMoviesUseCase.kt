package kr.co.bullets.tmdbclientreview.domain.usecase

import kr.co.bullets.tmdbclientreview.data.model.movie.Movie
import kr.co.bullets.tmdbclientreview.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}