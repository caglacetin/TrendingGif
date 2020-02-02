package com.cagla.trendgifapp.common.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cagla.trendgifapp.common.di.ViewModelFactory
import com.cagla.trendgifapp.common.di.key.ViewModelKey
import com.cagla.trendgifapp.ui.TrendingGifViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

  @IntoMap
  @Binds
  @ViewModelKey(TrendingGifViewModel::class)
  abstract fun provideTrendingGifViewModel(trendingGifViewModel: TrendingGifViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}