package com.cagla.trendgifapp.common.di.module

import com.cagla.trendgifapp.data.NetworkModule
import dagger.Module

@Module(
  includes = [NetworkModule::class]
)
class DataModule {
}