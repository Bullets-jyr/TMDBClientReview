package kr.co.bullets.tmdbclientreview.data.api

import kr.co.bullets.tmdbclientreview.data.ArtistList
import kr.co.bullets.tmdbclientreview.data.MovieList
import kr.co.bullets.tmdbclientreview.data.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Base url : https://api.themoviedb.org/3
// End Point : /movie/popular
// Query parameters : ?api_key=<<api_key>>&language=en-US&page=1
interface TMDBService {
    // Since we are going to use coroutines for background processing, we need to define these as suspending functions
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>
}