package com.x1oto.harrypotterwiki.presentation.adapters.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.x1oto.harrypotterwiki.data.models.character.CharacterItem
import com.x1oto.harrypotterwiki.data.models.spell.SpellItem
import com.x1oto.harrypotterwiki.data.models.spell.Spells
import com.x1oto.harrypotterwiki.databinding.ItemSpellBinding

class SpellAdapter(private val spells: Spells, private val onItemClick: (SpellItem) -> Unit) : RecyclerView.Adapter<SpellAdapter.SpellViewHolder>() {

    class SpellViewHolder(val binding: ItemSpellBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(currentSpell: SpellItem, onItemClick: (SpellItem) -> Unit) {
            with(binding) {
                title.text = currentSpell.name

                itemCl.setOnClickListener {
                    onItemClick(currentSpell)
                }
            }
        }


        companion object {
            fun from(parent: ViewGroup): SpellViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSpellBinding.inflate(layoutInflater, parent, false)
                return SpellViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SpellAdapter.SpellViewHolder = SpellViewHolder.from(parent)


    override fun onBindViewHolder(
        holder: SpellAdapter.SpellViewHolder,
        position: Int
    ) {
        holder.bind(spells[position], onItemClick)
    }

    override fun getItemCount() = spells.size

}