package com.example.android3lesson2dz.ui.fragments.character

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android3lesson2dz.R
import com.example.android3lesson2dz.base.BaseFragment
import com.example.android3lesson2dz.databinding.FragmentCharacterDetailBinding
import com.example.android3lesson2dz.exeption.setImage

class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding, CharacterViewModel>(R.layout.fragment_character_detail) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel: CharacterViewModel by activityViewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchDetailCharacters(args.id).observe(viewLifecycleOwner) {
            binding.tvCharacterDetailName.text = it.name
            binding.imgCharacterDetailPerson.setImage(it.image)
        }
    }
}
