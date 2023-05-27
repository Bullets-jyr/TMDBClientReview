package kr.co.bullets.tmdbclientreview.presentation.di.artist

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclientreview.domain.usecase.GetArtistsUseCase
import kr.co.bullets.tmdbclientreview.domain.usecase.UpdateArtistsUseCase
import kr.co.bullets.tmdbclientreview.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistsUseCase: GetArtistsUseCase, updateArtistsUseCase: UpdateArtistsUseCase): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}