package kr.co.bullets.tmdbclientreview.data.repository.artist.datasource

import kr.co.bullets.tmdbclientreview.data.model.artist.Artist

interface ArtistLocalDatasource {
    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsToDB(artists: List<Artist>)

    suspend fun clearAll()
}