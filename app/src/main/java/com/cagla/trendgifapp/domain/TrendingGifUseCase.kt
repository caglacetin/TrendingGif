package com.cagla.trendgifapp.domain

import com.cagla.trendgifapp.common.Resource
import com.cagla.trendgifapp.data.GiphyRepository
import com.cagla.trendgifapp.data.response.TrendingGifModel
import io.reactivex.Observable
import javax.inject.Inject

class TrendingGifUseCase @Inject constructor(
  private val repository: GiphyRepository,
  private val trendingGifMapper: TrendingGifMapper
) {

  fun fetchTrendingGifs(): Observable<Resource<List<TrendingGifModel>>> {
    return repository.fetchTrendingGifs()
      .map { resource ->
        Resource(
          status = resource.status,
          data = resource.data?.let { trendingGifMapper.mapFrom(it) },
          error = resource.error
        )
      }
  }

}