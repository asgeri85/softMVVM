package net.asgeri.soft31may.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("load_image_api")
fun loadImage(imageView: ImageView, url: String) {
    imageView.loadImageUrl(url)
}