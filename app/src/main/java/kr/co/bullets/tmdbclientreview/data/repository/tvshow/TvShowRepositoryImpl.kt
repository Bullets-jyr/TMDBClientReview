package kr.co.bullets.tmdbclientreview.data.repository.tvshow

import android.util.Log
import kr.co.bullets.tmdbclientreview.data.model.artist.Artist
import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.artist.datasource.ArtistRemoteDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowCacheDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowLocalDatasource
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowRemoteDatasource
import kr.co.bullets.tmdbclientreview.domain.repository.ArtistRepository
import kr.co.bullets.tmdbclientreview.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(private val tvShowRemoteDatasource: TvShowRemoteDatasource, private val tvShowLocalDatasource: TvShowLocalDatasource, private val tvShowCacheDatasource: TvShowCacheDatasource) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfMovies = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfMovies)
        tvShowCacheDatasource.saveTvShowsToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDatasource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDatasource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }
}