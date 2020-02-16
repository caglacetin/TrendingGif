package com.cagla.trendgifapp.data

import com.cagla.trendgifapp.data.response.TrendingGifResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface GiphyService {

  @GET("trending")
  fun fetchTrendingGif(): Observable<TrendingGifResponse>

}