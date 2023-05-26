package kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource

import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(movies: List<TvShow>)
}