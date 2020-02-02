package com.cagla.trendgifapp.ui

import com.cagla.trendgifapp.common.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class TrendingGifActivityModule {

  @Provides
  @ActivityScope
  fun provideTrendingGifAdapter(): TrendingGifAdapter {
    return TrendingGifAdapter()
  }


}