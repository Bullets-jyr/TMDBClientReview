package kr.co.bullets.tmdbclientreview.data.repository.artist.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.bullets.tmdbclientreview.data.db.ArtistDao
import kr.co.bullets.tmdbclientreview.data.model.artist.Artist
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistLocalDatasource

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao) : ArtistLocalDatasource {
    // when we are getting data from the room database, room execute that query in a background thread
    // so we don't need to explicitly write codes for background processing
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    // but, we need to invoke other dao functions from a background thread
    // we will use coroutines for that
    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        // to run this in a background worker thread, using Dispatcher.IO
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}