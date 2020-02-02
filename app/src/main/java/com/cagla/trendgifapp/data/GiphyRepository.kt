package com.cagla.trendgifapp.data

import com.cagla.trendgifapp.common.Resource
import com.cagla.trendgifapp.common.ui.applyLoading
import com.cagla.trendgifapp.data.response.TrendingGifResponse
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable
import javax.inject.Inject

class GiphyRepository @Inject constructor(private val giphyRemoteDataSource: GiphyRemoteDataSource) {

  fun fetchTrendingGifs(): Observable<Resource<TrendingGifResponse>> =
    giphyRemoteDataSource
      .fetchTrendingGifs()
      .map { Resource.success(it) }
      .onErrorReturn { Resource.error(it) }
      .subscribeOn(Schedulers.io())
      .compose(applyLoading())


}