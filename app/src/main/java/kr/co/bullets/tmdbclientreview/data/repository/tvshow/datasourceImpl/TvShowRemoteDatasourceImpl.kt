package kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasourceImpl

import kr.co.bullets.tmdbclientreview.data.api.TMDBService
import kr.co.bullets.tmdbclientreview.data.model.artist.ArtistList
import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShowList
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}