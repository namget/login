package com.namget.logintest.ui.search.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.namget.logintest.util.setImageWithGlide

@BindingAdapter("android:url")
fun ImageView.setGlideImage(url: String) {
    setImageWithGlide(url)
}