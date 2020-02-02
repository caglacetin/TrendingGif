package com.cagla.trendgifapp.data.response

import com.cagla.trendgifapp.data.PaginationModel

data class TrendingGifResponse (
  val data: List<TrendingGifModel>,
  val pagination: PaginationModel
)