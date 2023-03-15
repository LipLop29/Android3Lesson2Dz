package com.example.android3lesson2dz.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3lesson2dz.databinding.ItemCharacterBinding
import com.example.android3lesson2dz.models.CharacterModel

class CharacterAdapter :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var list: List<CharacterModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CharacterModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(characterModel: CharacterModel) {
            binding.itemCharacterName.text = characterModel.name
            binding.tvGender.text = characterModel.gender
            binding.tvStatus.text = characterModel.status

            val logoPath = characterModel.image
            Glide
                .with(binding.imgPerson.context)
                .load(logoPath)
                .into(binding.imgPerson)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}