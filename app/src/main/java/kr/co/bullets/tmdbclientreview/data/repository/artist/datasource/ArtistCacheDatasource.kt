package kr.co.bullets.tmdbclientreview.data.repository.artist.datasource

import kr.co.bullets.tmdbclientreview.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(artists: List<Artist>)
}