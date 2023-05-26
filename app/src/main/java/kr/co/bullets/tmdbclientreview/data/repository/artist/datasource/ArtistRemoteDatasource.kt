package kr.co.bullets.tmdbclientreview.data.repository.artist.datasource

import kr.co.bullets.tmdbclientreview.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}