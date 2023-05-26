package kr.co.bullets.tmdbclientreview.data.repository.artist

import android.util.Log
import kr.co.bullets.tmdbclientreview.data.model.artist.Artist
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistRemoteDatasource
import kr.co.bullets.tmdbclientreview.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(private val artistRemoteDatasource: ArtistRemoteDatasource, private val artistLocalDatasource: ArtistLocalDatasource, private val artistCacheDatasource: ArtistCacheDatasource) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfMovies = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfMovies)
        artistCacheDatasource.saveArtistsToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDatasource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDatasource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}