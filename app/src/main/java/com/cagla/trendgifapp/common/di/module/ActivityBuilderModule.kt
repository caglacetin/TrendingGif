package com.cagla.trendgifapp.common.di.module

import com.cagla.trendgifapp.MainActivity
import com.cagla.trendgifapp.common.di.scope.ActivityScope
import com.cagla.trendgifapp.ui.TrendingGifActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = [TrendingGifActivityModule::class])
  abstract fun bindMainActivity(): MainActivity
}