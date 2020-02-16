package com.cagla.trendgifapp.common.ui

import android.view.View
import androidx.databinding.BindingAdapter

object ImageBindingAdapter {

  @JvmStatic
  @BindingAdapter("visibleIf")
  fun changeVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
  }
}