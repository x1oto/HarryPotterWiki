package com.x1oto.harrypotterwiki.presentation.adapters.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x1oto.harrypotterwiki.data.models.character.Characters
import com.x1oto.harrypotterwiki.data.models.character.CharacterItem
import com.x1oto.harrypotterwiki.databinding.ItemCharacterBinding

class CharacterAdapter(private val characters: Characters) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(currentCharacter: CharacterItem) {
            with(binding) {
                characterItem = currentCharacter
                characterName.text = currentCharacter.name
                houseInfo.text = currentCharacter.house
                genderInfo.text = currentCharacter.gender
                birthInfo.text = currentCharacter.dateOfBirth
            }
        }


        companion object {
            fun from(parent: ViewGroup): CharacterViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)
                return CharacterViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterViewHolder = CharacterViewHolder.from(parent)


    override fun onBindViewHolder(
        holder: CharacterAdapter.CharacterViewHolder,
        position: Int
    ) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size

}