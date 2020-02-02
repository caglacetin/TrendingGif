package com.cagla.trendgifapp.domain

import com.cagla.trendgifapp.common.Mapper
import com.cagla.trendgifapp.data.response.TrendingGifModel
import com.cagla.trendgifapp.data.response.TrendingGifResponse
import javax.inject.Inject

class TrendingGifMapper @Inject constructor(): Mapper<TrendingGifResponse, List<TrendingGifModel>>{

  override fun mapFrom(type: TrendingGifResponse): List<TrendingGifModel> {
    return type.data.map { itemResponse ->
      TrendingGifModel(
        url = itemResponse.url
      )
    }
  }

}