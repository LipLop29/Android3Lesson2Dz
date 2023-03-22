package com.example.android3lesson2dz.exeption

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(uri: String) {
    Glide.with(this)
        .load(uri)
        .into(this)
}