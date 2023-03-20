package com.example.android3lesson2dz.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android3lesson2dz.databinding.ItemLocationBinding
import com.example.android3lesson2dz.models.LocationModel

class LocationAdapter(val onItemClick: (id: Int) -> Unit) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private var list: List<LocationModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<LocationModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(list[adapterPosition].id)
            }
        }

        fun onBind(locationModel: LocationModel) = with(binding) {
            tvLocationType.text = locationModel.type
            tvLocationName.text = locationModel.name
            tvLocationDimension.text = locationModel.dimension
            tvLocationCreated.text = locationModel.created
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

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}