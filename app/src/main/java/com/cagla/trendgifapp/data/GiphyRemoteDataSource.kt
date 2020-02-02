package com.cagla.trendgifapp.data

import javax.inject.Inject

class GiphyRemoteDataSource @Inject constructor(private val giphyService: GiphyService) {

  fun fetchTrendingGifs() = giphyService.fetchTrendingGif()
}