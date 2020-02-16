package com.cagla.trendgifapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.cagla.trendgifapp.R
import com.cagla.trendgifapp.common.ui.observeNonNull
import com.cagla.trendgifapp.common.ui.runIfNull
import com.cagla.trendgifapp.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  internal lateinit var viewModelProviderFactory: ViewModelProvider.Factory

  private lateinit var binding: ActivityMainBinding
  private lateinit var trendingGifViewModel: TrendingGifViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    trendingGifViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(TrendingGifViewModel::class.java)

    trendingGifViewModel.getTrendingGifsLiveData().observeNonNull(this) {
      renderTrendingGifs(it)
    }

    savedInstanceState.runIfNull {
      fetchTrendingGifs()
    }

  }

  private fun fetchTrendingGifs() {
    trendingGifViewModel.fetchTrendingGifs()
  }

  private fun renderTrendingGifs(feedViewState: TrendingGifViewState) {
    with(binding) {
      viewState = feedViewState
      executePendingBindings()
    }
    if (feedViewState.getTrendingGifs().isNotEmpty()) {
      Glide.with(this).load(feedViewState.getTrendingGifs()[0].url).into(gifImageView)
    }
  }

}
