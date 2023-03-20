package com.example.android3lesson2dz.ui.fragments.location

import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android3lesson2dz.R
import com.example.android3lesson2dz.base.BaseFragment
import com.example.android3lesson2dz.databinding.FragmentLocationBinding
import com.example.android3lesson2dz.ui.adapters.LocationAdapter

class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by activityViewModels()
    private var locationAdapter = LocationAdapter(this::onItemClick)

    override fun initialize() {
        binding.recyclerLocation.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchLocation().observe(viewLifecycleOwner) {
            locationAdapter.setList(it.results)
        }
    }

    private fun onItemClick(id:Int) {
        val action: NavDirections =
            LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(id)
        findNavController().navigate(action)
    }
}