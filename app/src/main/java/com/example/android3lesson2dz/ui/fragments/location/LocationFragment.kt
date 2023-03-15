package com.example.android3lesson2dz.ui.fragments.location

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android3lesson2dz.databinding.FragmentLocationBinding
import com.example.android3lesson2dz.ui.adapters.LocationAdapter

class LocationFragment : Fragment() {

    private lateinit var binding: FragmentLocationBinding
    private lateinit var viewModel: LocationViewModel
    private var locationAdapter = LocationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LocationViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.recyclerLocation.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    private fun setupObserve() {
        viewModel.fetchLocation().observe(viewLifecycleOwner) {
            locationAdapter.setList(it.results)
        }
    }
}