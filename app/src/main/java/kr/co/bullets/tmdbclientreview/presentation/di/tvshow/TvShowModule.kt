package kr.co.bullets.tmdbclientreview.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.domain.usecase.GetTvShowsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateTvShowsUseCase
import kr.co.bullets.tmdbclientreview.presentation.tvshow.TvShowViewModelFactory

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowsUseCase: GetTvShowsUseCase, updateTvShowsUseCase: UpdateTvShowsUseCase): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}