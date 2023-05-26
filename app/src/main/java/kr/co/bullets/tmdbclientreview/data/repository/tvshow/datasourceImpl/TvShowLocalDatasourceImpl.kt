package kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.bullets.tmdbclientreview.data.db.TvShowDao
import kr.co.bullets.tmdbclientreview.data.model.tvshow.TvShow
import kr.co.bullets.tmdbclientreview.data.repository.tvshow.datasource.TvShowLocalDatasource

class TvShowLocalDatasourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDatasource {
    // when we are getting data from the room database, room execute that query in a background thread
    // so we don't need to explicitly write codes for background processing
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    // but, we need to invoke other dao functions from a background thread
    // we will use coroutines for that
    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        // to run this in a background worker thread, using Dispatcher.IO
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}