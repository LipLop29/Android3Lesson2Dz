package com.example.android3lesson2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android3lesson2dz.databinding.ItemCharacterBinding
import com.example.android3lesson2dz.exeption.setImage
import com.example.android3lesson2dz.models.CharacterModel

class CharacterAdapter(val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<CharacterModel, CharacterAdapter.CharacterViewHolder>(diffUtil) {

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { character -> onItemClick(character.id) }
            }
        }

        fun onBind(item: CharacterModel?) {
            binding.itemTvCharacterGender.text = item?.gender
            binding.itemTvCharacterStatus.text = item?.status
            binding.itemTvCharacterName.text = item?.name
            binding.itemImgCharacterPerson.setImage(item!!.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<CharacterModel>() {
            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}