package com.x1oto.harrypotterwiki.presentation.adapters.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x1oto.harrypotterwiki.data.models.Character
import com.x1oto.harrypotterwiki.data.models.CharacterItem
import com.x1oto.harrypotterwiki.databinding.ItemCharacterBinding

class ItemCharacterAdapter(private val character: Character) : RecyclerView.Adapter<ItemCharacterAdapter.ItemCharacterViewHolder>() {

    class ItemCharacterViewHolder(val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(currentCharacter: CharacterItem) {
            with(binding) {
                binding.characterItem = currentCharacter
                characterName.text = currentCharacter.name
            }
        }


        companion object {
            fun from(parent: ViewGroup): ItemCharacterViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)
                return ItemCharacterViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemCharacterAdapter.ItemCharacterViewHolder = ItemCharacterViewHolder.from(parent)


    override fun onBindViewHolder(
        holder: ItemCharacterAdapter.ItemCharacterViewHolder,
        position: Int
    ) {
        holder.bind(character[position])
    }

    override fun getItemCount() = character.size

}