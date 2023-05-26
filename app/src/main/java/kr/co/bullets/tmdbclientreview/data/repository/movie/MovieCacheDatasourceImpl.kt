package kr.co.bullets.tmdbclientreview.data.repository.movie

import kr.co.bullets.tmdbclientreview.data.model.movie.Movie

class MovieCacheDatasourceImpl : MovieCacheDatasource {
    // we will create an ArrayList of movie instances
    // then, whenever the user launches the app and load movie data for the first time we will assign that list to this ArrayList
    // we will keep this MovieCacheDataSourceImpl instance which holds the ArrayList as a singleton using dagger
    // so, if the user wants to load the movie list again, instead of using the database we can just use the cached list
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}