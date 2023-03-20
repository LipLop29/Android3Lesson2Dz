package com.example.android3lesson2dz.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android3lesson2dz.databinding.ItemEpisodeBinding
import com.example.android3lesson2dz.models.EpisodeModel

class EpisodeAdapter(val onItemClick: (id: Int) -> Unit) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private var list: List<EpisodeModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<EpisodeModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(list[adapterPosition].id)
            }
        }

        fun onBind(episodeModel: EpisodeModel) = with(binding) {
            tvEpisodeCreated.text = episodeModel.created
            tvEpisodeEpisode.text = episodeModel.episode
            tvEpisodeName.text = episodeModel.name
            tvEpisodeAirDate.text = episodeModel.air_date
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