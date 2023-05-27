package kr.co.bullets.tmdbclientreview.presentation.di.core

import dagger.Component
import kr.co.bullets.tmdbclientreview.presentation.di.artist.ArtistSubComponent
import kr.co.bullets.tmdbclientreview.presentation.di.movie.MovieSubComponent
import kr.co.bullets.tmdbclientreview.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
])
interface AppComponent {
    // define functions to get subcomponent factories
    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvShowSubComponent(): TvShowSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory
}