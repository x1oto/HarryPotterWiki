package com.x1oto.harrypotterwiki.presentation.adapters.bindingadapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.x1oto.harrypotterwiki.data.models.spell.SpellItem
import com.x1oto.harrypotterwiki.presentation.adapters.recycler.SpellAdapter
import com.x1oto.harrypotterwiki.presentation.utils.CharacterStatus
import com.x1oto.harrypotterwiki.presentation.utils.SpellStatus

class SpellsBinding {
    companion object {
        @BindingAdapter(
            "configureRvOnSpellsFragment",
            "onItemClicked",
            requireAll = true
        )
        @JvmStatic
        fun configureRvOnSpellsFragment(recyclerView: RecyclerView, spellsStatus: SpellStatus, onItemClicked: (SpellItem) -> Unit) {
            when (spellsStatus) {
                is SpellStatus.Success -> {
                    recyclerView.visibility = View.VISIBLE
                    recyclerView.adapter = SpellAdapter(spellsStatus.spells, onItemClicked)
                }
                is SpellStatus.Error -> recyclerView.visibility = View.INVISIBLE
                SpellStatus.Loading -> recyclerView.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("configureCvOnSpellsFragment")
        @JvmStatic
        fun configureCvOnSpellsFragment(cardView: MaterialCardView, spellsStatus: SpellStatus) {
            when (spellsStatus) {
                is SpellStatus.Success -> cardView.visibility = View.INVISIBLE
                is SpellStatus.Error -> cardView.visibility = View.VISIBLE
                SpellStatus.Loading -> cardView.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("configureCpiOnSpellsFragment")
        @JvmStatic
        fun configureCpiOnSpellsFragment(circularProgressIndicator: CircularProgressIndicator, spellsStatus: SpellStatus) {
            when (spellsStatus) {
                is SpellStatus.Success -> circularProgressIndicator.visibility = View.INVISIBLE
                is SpellStatus.Error -> circularProgressIndicator.visibility = View.INVISIBLE
                SpellStatus.Loading -> circularProgressIndicator.visibility = View.VISIBLE
            }
        }

        @BindingAdapter("configureTvOnSpellsFragment")
        @JvmStatic
        fun configureTvOnSpellsFragment(textView: TextView, spellsStatus: SpellStatus) {
            when (spellsStatus) {
                is SpellStatus.Error -> {
                    textView.text = spellsStatus.error
                }
                else -> {}
            }
        }
    }
}