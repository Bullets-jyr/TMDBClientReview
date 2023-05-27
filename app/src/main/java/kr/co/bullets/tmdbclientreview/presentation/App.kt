package kr.co.bullets.tmdbclientreview.presentation

import android.app.Application
import kr.co.bullets.tmdbclientreview.BuildConfig
import kr.co.bullets.tmdbclientreview.presentation.di.Injector
import kr.co.bullets.tmdbclientreview.presentation.di.artist.ArtistSubComponent
import kr.co.bullets.tmdbclientreview.presentation.di.core.AppComponent
import kr.co.bullets.tmdbclientreview.presentation.di.core.AppModule
import kr.co.bullets.tmdbclientreview.presentation.di.core.DaggerAppComponent
import kr.co.bullets.tmdbclientreview.presentation.di.core.NetModule
import kr.co.bullets.tmdbclientreview.presentation.di.core.RemoteDataModule
import kr.co.bullets.tmdbclientreview.presentation.di.movie.MovieSubComponent
import kr.co.bullets.tmdbclientreview.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}