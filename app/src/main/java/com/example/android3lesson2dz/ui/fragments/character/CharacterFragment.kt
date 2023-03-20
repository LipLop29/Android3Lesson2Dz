package com.example.android3lesson2dz.ui.fragments.character

import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android3lesson2dz.R
import com.example.android3lesson2dz.base.BaseFragment
import com.example.android3lesson2dz.databinding.FragmentCharacterBinding
import com.example.android3lesson2dz.ui.adapters.CharacterAdapter

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding,CharacterViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by activityViewModels()
    private var characterAdapter = CharacterAdapter(this::onItemClick)

    override fun initialize() {
        binding.recyclerCharacter.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchCharacter().observe(viewLifecycleOwner) {
            characterAdapter.setList(it.results)
        }
    }

    private fun onItemClick(id: Int) {
        val action: NavDirections =
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(id)
        findNavController().navigate(action)
    }
}