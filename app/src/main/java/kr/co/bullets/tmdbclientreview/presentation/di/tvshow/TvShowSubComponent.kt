package kr.co.bullets.tmdbclientreview.presentation.di.tvshow

import dagger.Subcomponent
import kr.co.bullets.tmdbclientreview.presentation.tvshow.TvShowActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    // we will use this subcomponent to inject dependencies to artist activity
    // therefore we need to define an inject function here keeping an instance of artist activity as a parameter
    fun inject(tvShowActivity: TvShowActivity)

    // we must define a subcomponent factory inside this artistcomponent so that appcomponent knows how to create instances of this artistcomponent subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}