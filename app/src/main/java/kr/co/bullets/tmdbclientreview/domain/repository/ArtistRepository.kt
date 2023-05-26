package kr.co.bullets.tmdbclientreview.domain.repository

import kr.co.bullets.tmdbclientreview.data.model.artist.Artist
import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}