package com.cagla.trendgifapp.ui

import com.cagla.trendgifapp.common.Status
import com.cagla.trendgifapp.data.response.TrendingGifModel

class TrendingGifViewState(
  private val status: Status,
  private val error: Throwable? = null,
  private val data: List<TrendingGifModel>? = null
) {

  fun getTrendingGifs() = data?: mutableListOf()

  fun isLoading() = status == Status.LOADING

  fun getErrorMessage() = error?.message

  fun shouldShowErrorMessage() = error != null

}