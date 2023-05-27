package kr.co.bullets.tmdbclientreview.presentation.di

import kr.co.bullets.tmdbclientreview.presentation.di.artist.ArtistSubComponent
import kr.co.bullets.tmdbclientreview.presentation.di.movie.MovieSubComponent
import kr.co.bullets.tmdbclientreview.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent

    fun createTvShowSubComponent(): TvShowSubComponent

    fun createArtistSubComponent(): ArtistSubComponent
}