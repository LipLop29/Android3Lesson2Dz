package com.example.android3lesson2dz.ui.fragments.episode

import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android3lesson2dz.R
import com.example.android3lesson2dz.base.BaseFragment
import com.example.android3lesson2dz.databinding.FragmentEpisodeBinding
import com.example.android3lesson2dz.ui.adapters.EpisodeAdapter

class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by activityViewModels()
    private var episodeAdapter = EpisodeAdapter(this::onItemClick)

    override fun initialize() {
        binding.recyclerEpisode.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchEpisode().observe(viewLifecycleOwner) {
            episodeAdapter.setList(it.results)
        }
    }

    private fun onItemClick(id:Int) {
        val action: NavDirections =
            EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(id)
        findNavController().navigate(action)
    }
}