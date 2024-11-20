package com.x1oto.harrypotterwiki.presentation.adapters.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

class ItemCharacterBinding {
    companion object {
        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
            imageView.load(imageUrl) {
                crossfade(600)
            }
        }
    }
}