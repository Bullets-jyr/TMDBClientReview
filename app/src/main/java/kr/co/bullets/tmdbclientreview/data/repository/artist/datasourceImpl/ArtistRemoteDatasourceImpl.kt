package kr.co.bullets.tmdbclientreview.data.repository.artist.datasourceImpl

import kr.co.bullets.tmdbclientreview.data.api.TMDBService
import kr.co.bullets.tmdbclientreview.data.model.artist.ArtistList
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}