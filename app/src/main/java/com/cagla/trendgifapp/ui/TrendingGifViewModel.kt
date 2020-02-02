package com.cagla.trendgifapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cagla.trendgifapp.common.Resource
import com.cagla.trendgifapp.common.RxAwareViewModel
import com.cagla.trendgifapp.common.ui.plusAssign
import com.cagla.trendgifapp.data.response.TrendingGifModel
import com.cagla.trendgifapp.domain.TrendingGifUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class TrendingGifViewModel @Inject constructor(private val trendingGifUseCase: TrendingGifUseCase) :
  RxAwareViewModel() {

  private val trendingGifLiveData = MutableLiveData<TrendingGifViewState>()

  fun getTrendingGifsLiveData() : LiveData<TrendingGifViewState> = trendingGifLiveData

  fun fetchTrendingGifs() {
    trendingGifUseCase
      .fetchTrendingGifs()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(this::onTrendingGifResultReady)
      .also { disposable += it }
  }

  private fun onTrendingGifResultReady(resource: Resource<List<TrendingGifModel>>) {
    trendingGifLiveData.value =
      TrendingGifViewState(
        status = resource.status,
        error = resource.error,
        data = resource.data
      )
  }

}