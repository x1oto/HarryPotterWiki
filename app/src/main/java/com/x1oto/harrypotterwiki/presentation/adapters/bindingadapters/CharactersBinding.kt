package com.x1oto.harrypotterwiki.presentation.adapters.bindingadapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.x1oto.harrypotterwiki.data.models.character.CharacterItem
import com.x1oto.harrypotterwiki.data.models.spell.SpellItem
import com.x1oto.harrypotterwiki.presentation.adapters.recycler.CharacterAdapter
import com.x1oto.harrypotterwiki.presentation.adapters.recycler.SpellAdapter
import com.x1oto.harrypotterwiki.presentation.utils.CharacterStatus

class CharactersBinding {
    companion object {
        @BindingAdapter(
            "configureRvOnCharFragment",
            "onItemClicked",
            "onTeachClicked",
            requireAll = true
        )
        @JvmStatic
        fun configureRvOnCharFragment(
            recyclerView: RecyclerView,
            characterStatus: CharacterStatus,
            onItemClicked: (CharacterItem) -> Unit,
            onTeachClicked: (String) -> Unit
        ) {
            when (characterStatus) {
                is CharacterStatus.Success -> {
                    recyclerView.visibility = View.VISIBLE
                    recyclerView.adapter =
                        CharacterAdapter(characterStatus.characters, onItemClicked, onTeachClicked)
                }

                is CharacterStatus.Error -> recyclerView.visibility = View.INVISIBLE
                CharacterStatus.Loading -> recyclerView.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("setVisibilityCv")
        @JvmStatic
        fun setVisibilityCv(cardView: MaterialCardView, characterStatus: CharacterStatus) {
            when (characterStatus) {
                is CharacterStatus.Success -> cardView.visibility = View.INVISIBLE
                is CharacterStatus.Error -> cardView.visibility = View.VISIBLE
                CharacterStatus.Loading -> cardView.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("setVisibilityCpi")
        @JvmStatic
        fun setVisibilityCpi(
            circularProgressIndicator: CircularProgressIndicator,
            characterStatus: CharacterStatus
        ) {
            when (characterStatus) {
                is CharacterStatus.Success -> circularProgressIndicator.visibility = View.INVISIBLE
                is CharacterStatus.Error -> circularProgressIndicator.visibility = View.INVISIBLE
                CharacterStatus.Loading -> circularProgressIndicator.visibility = View.VISIBLE
            }
        }

        @BindingAdapter("setErrorTextTv")
        @JvmStatic
        fun setErrorText(textView: TextView, characterStatus: CharacterStatus) {
            when (characterStatus) {
                is CharacterStatus.Error -> {
                    textView.text = characterStatus.error
                }

                else -> {}
            }
        }

    }
}