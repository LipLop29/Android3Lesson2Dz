package com.example.android3lesson2dz.ui.fragments.location

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android3lesson2dz.R
import com.example.android3lesson2dz.base.BaseFragment
import com.example.android3lesson2dz.databinding.FragmentLocationDetailBinding

class LocationDetailFragment  :
    BaseFragment<FragmentLocationDetailBinding, LocationViewModel>(R.layout.fragment_location_detail) {

    override val binding by viewBinding(FragmentLocationDetailBinding::bind)
    override val viewModel: LocationViewModel by activityViewModels()
    private val args by navArgs<LocationDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchDetailLocation(args.id).observe(viewLifecycleOwner) {
            binding.tvLocationDetailName.text = it.name
            binding.tvLocationDetailCreated.text = it.created
        }
    }
}