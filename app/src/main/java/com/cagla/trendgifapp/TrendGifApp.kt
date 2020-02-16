package com.cagla.trendgifapp

import android.app.Application
import com.cagla.trendgifapp.common.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TrendGifApp: Application(), HasAndroidInjector {

  @Inject
  internal lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> = androidInjector

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent
      .builder()
      .application(this)
      .build()
      .inject(this)
  }

}