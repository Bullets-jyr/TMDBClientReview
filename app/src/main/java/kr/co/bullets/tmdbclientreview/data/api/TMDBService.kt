package kr.co.bullets.tmdbclientreview.data.api

import kr.co.bullets.tmdbclientreview.data.model.artist.ArtistList
import kr.co.bullets.tmdbclientreview.data.model.movie.MovieList
import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Base url : https://api.themoviedb.org/3
// End Point : /movie/popular
// Query parameters : ?api_key=<<api_key>>&language=en-US&page=1
interface TMDBService {
    // since we are going to use coroutines for background processing, we need to define these as suspending functions
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>
}