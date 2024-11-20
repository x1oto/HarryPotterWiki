package com.x1oto.harrypotterwiki.presentation.adapters.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.x1oto.harrypotterwiki.R
import coil.load

class ItemCharacterBinding {
    companion object {
        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
            imageView.load(imageUrl) {
                crossfade(600)
                error(R.drawable.image_placeholder)
            }
        }
    }
}