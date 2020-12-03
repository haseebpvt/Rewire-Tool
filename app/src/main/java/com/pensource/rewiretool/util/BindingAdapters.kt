package com.pensource.rewiretool.util

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("enableDisableView")
fun enableDisableView(view: View, state: Boolean) {
    if (state) {
        view.alpha = 1f
        view.isEnabled = true
        view.isClickable = true
    } else {
        view.alpha = .5f
        view.isEnabled = false
        view.isClickable = false
    }
}