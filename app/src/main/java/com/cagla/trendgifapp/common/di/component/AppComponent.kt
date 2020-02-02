package com.cagla.trendgifapp.common.di.component

import android.app.Application
import com.cagla.trendgifapp.TrendGifApp
import com.cagla.trendgifapp.common.di.module.ActivityBuilderModule
import com.cagla.trendgifapp.common.di.module.DataModule
import com.cagla.trendgifapp.common.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    DataModule::class
  ]
)
interface AppComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent
  }

  fun inject(app: TrendGifApp)
}