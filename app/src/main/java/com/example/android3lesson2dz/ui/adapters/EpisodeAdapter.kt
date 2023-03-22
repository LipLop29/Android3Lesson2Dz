package com.example.android3lesson2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android3lesson2dz.databinding.ItemEpisodeBinding
import com.example.android3lesson2dz.models.EpisodeModel

class EpisodeAdapter(val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<EpisodeModel, EpisodeAdapter.EpisodeViewHolder>(diffUtil) {

    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { episode -> onItemClick(episode.id) }
            }
        }

        fun onBind(episodeModel: EpisodeModel) = with(binding) {
            itemTvEpisodeCreated.text = episodeModel.created
            itemTvEpisodeEpisode.text = episodeModel.episode
            itemTvEpisodeName.text = episodeModel.name
            itemTvEpisodeAirDate.text = episodeModel.air_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<EpisodeModel>() {
            override fun areItemsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}