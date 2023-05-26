package kr.co.bullets.tmdbclientreview.domain.usecase

import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow
import kr.co.bullets.tmdbclientreview.domain.repository.TvShowRepository

class UpdateTvShowsUsecase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}