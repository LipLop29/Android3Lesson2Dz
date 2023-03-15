package com.example.android3lesson2dz.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android3lesson2dz.databinding.ItemEpisodeBinding
import com.example.android3lesson2dz.models.EpisodeModel

class EpisodeAdapter :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private var list: List<EpisodeModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<EpisodeModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(episodeModel: EpisodeModel) = with(binding) {
            tvCreated.text = episodeModel.created
            tvEpisode.text = episodeModel.episode
            tvName.text = episodeModel.name
            tvAirDate.text = episodeModel.air_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}