package kr.co.bullets.tmdbclientreview.data.repository.artist.datasourceImpl

import kr.co.bullets.tmdbclientreview.data.model.artist.Artist
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl : ArtistCacheDatasource {
    // we will create an ArrayList of movie instances
    // then, whenever the user launches the app and load movie data for the first time we will assign that list to this ArrayList
    // we will keep this MovieCacheDataSourceImpl instance which holds the ArrayList as a singleton using dagger
    // so, if the user wants to load the movie list again, instead of using the database we can just use the cached list
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}