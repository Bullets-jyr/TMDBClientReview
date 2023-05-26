package kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource

import kr.co.bullets.tmdbclientreview.data.model.artist.ArtistList
import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}