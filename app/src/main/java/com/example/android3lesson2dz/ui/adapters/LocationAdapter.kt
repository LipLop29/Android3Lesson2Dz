package com.example.android3lesson2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android3lesson2dz.databinding.ItemLocationBinding
import com.example.android3lesson2dz.models.LocationModel

class LocationAdapter(val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<LocationModel, LocationAdapter.LocationViewHolder>(diffUtil) {

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { loacation -> onItemClick(loacation.id) }
            }
        }

        fun onBind(locationModel: LocationModel) = with(binding) {
            itemTvLocationType.text = locationModel.type
            itemTvLocationName.text = locationModel.name
            itemTvLocationDimension.text = locationModel.dimension
            itemTvLocationCreated.text = locationModel.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: LocationAdapter.LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<LocationModel>() {
            override fun areItemsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}