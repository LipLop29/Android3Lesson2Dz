package com.example.android3lesson2dz.ui.fragments.character

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android3lesson2dz.databinding.FragmentCharacterBinding
import com.example.android3lesson2dz.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private lateinit var viewModel: CharacterViewModel
    private var characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    private fun setupObserve() {
        viewModel.fetchCharacter().observe(viewLifecycleOwner) {
            characterAdapter.setList(it.results)
        }
    }
}