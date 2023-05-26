package kr.co.bullets.tmdbclientreview.domain.usecase

import kr.co.bullets.tmdbclientreview.data.model.artist.Artist
import kr.co.bullets.tmdbclientreview.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}