package kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource

import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun saveTvShowsToDB(movies: List<TvShow>)

    suspend fun clearAll()
}