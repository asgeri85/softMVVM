package net.asgeri.soft31may.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import net.asgeri.soft31may.R

fun ImageView.loadImageUrl(url: String) {
    Glide.with(this).load(url).placeholder(R.drawable.place)
        .into(this)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}