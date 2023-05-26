package kr.co.bullets.tmdbclientreview.domain.repository

import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}