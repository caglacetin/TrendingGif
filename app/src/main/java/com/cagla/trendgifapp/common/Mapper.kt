package com.cagla.trendgifapp.common

interface Mapper<R, D> {
  fun mapFrom(type: R): D
}