package com.x1oto.harrypotterwiki.presentation.adapters.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.x1oto.harrypotterwiki.R
import com.x1oto.harrypotterwiki.data.models.character.CharacterItem
import com.x1oto.harrypotterwiki.data.models.character.Characters
import com.x1oto.harrypotterwiki.databinding.ItemHouseBinding

class HouseAdapter(private val characters: Characters) : RecyclerView.Adapter<HouseAdapter.HouseViewHolder>() {

    class HouseViewHolder(val binding: ItemHouseBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(currentCharacter: CharacterItem) {
            with(binding) {
                characterImage.load(currentCharacter.image) {
                    crossfade(600)
                    error(R.drawable.image_placeholder)
                }
                characterName.text = currentCharacter.name
                houseInfo.text = currentCharacter.house
                genderInfo.text = currentCharacter.gender
                birthInfo.text = currentCharacter.dateOfBirth
            }
        }


        companion object {
            fun from(parent: ViewGroup): HouseViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHouseBinding.inflate(layoutInflater, parent, false)
                return HouseViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HouseAdapter.HouseViewHolder = HouseViewHolder.from(parent)


    override fun onBindViewHolder(
        holder: HouseAdapter.HouseViewHolder,
        position: Int
    ) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size

}