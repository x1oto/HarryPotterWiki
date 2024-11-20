package com.x1oto.harrypotterwiki.presentation.adapters.bindingadapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.x1oto.harrypotterwiki.presentation.adapters.recycler.ItemCharacterAdapter
import com.x1oto.harrypotterwiki.presentation.utils.Status

class CharactersBinding {
    companion object {
        @BindingAdapter(
            "setVisibilityAndAdapterRv"
        )
        @JvmStatic
        fun setVisibilityAndAdapterRv(recyclerView: RecyclerView, status: Status) {
            when (status) {
                is Status.Success -> {
                    recyclerView.visibility = View.VISIBLE
                    recyclerView.adapter = ItemCharacterAdapter(status.character)
                }
                is Status.Error -> recyclerView.visibility = View.INVISIBLE
                Status.Loading -> recyclerView.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("setVisibilityCv")
        @JvmStatic
        fun setVisibilityCv(cardView: MaterialCardView, status: Status) {
            when (status) {
                is Status.Success -> cardView.visibility = View.INVISIBLE
                is Status.Error -> cardView.visibility = View.VISIBLE
                Status.Loading -> cardView.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("setVisibilityCpi")
        @JvmStatic
        fun setVisibilityCpi(circularProgressIndicator: CircularProgressIndicator, status: Status) {
            when (status) {
                is Status.Success -> circularProgressIndicator.visibility = View.INVISIBLE
                is Status.Error -> circularProgressIndicator.visibility = View.INVISIBLE
                Status.Loading -> circularProgressIndicator.visibility = View.VISIBLE
            }
        }

        @BindingAdapter("setErrorTextTv")
        @JvmStatic
        fun setErrorText(textView: TextView, status: Status) {
            when (status) {
                is Status.Error -> {
                    textView.text = status.error
                }
                else -> {}
            }
        }

    }
}