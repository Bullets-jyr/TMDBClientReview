package kr.co.bullets.tmdbclientreview.presentation.di.artist

import dagger.Subcomponent
import kr.co.bullets.tmdbclientreview.presentation.artist.ArtistActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    // we will use this subcomponent to inject dependencies to artist activity
    // therefore we need to define an inject function here keeping an instance of artist activity as a parameter
    fun inject(artistActivity: ArtistActivity)

    // we must define a subcomponent factory inside this artistcomponent so that appcomponent knows how to create instances of this artistcomponent subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}