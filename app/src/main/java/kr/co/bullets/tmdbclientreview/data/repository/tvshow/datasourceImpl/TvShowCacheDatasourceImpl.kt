package kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasourceImpl

import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl : TvShowCacheDatasource {
    // we will create an ArrayList of movie instances
    // then, whenever the user launches the app and load movie data for the first time we will assign that list to this ArrayList
    // we will keep this MovieCacheDataSourceImpl instance which holds the ArrayList as a singleton using dagger
    // so, if the user wants to load the movie list again, instead of using the database we can just use the cached list
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvshows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvshows)
    }
}