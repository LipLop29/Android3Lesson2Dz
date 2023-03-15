package com.example.android3lesson2dz.ui.fragments.episode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android3lesson2dz.databinding.FragmentEpisodeBinding
import com.example.android3lesson2dz.ui.adapters.EpisodeAdapter

class EpisodeFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeBinding
    private lateinit var viewModel: EpisodeViewModel
    private var episodeAdapter = EpisodeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[EpisodeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.recyclerEpisode.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    private fun setupObserve() {
        viewModel.fetchEpisode().observe(viewLifecycleOwner) {
            episodeAdapter.setList(it.results)
        }
    }
}