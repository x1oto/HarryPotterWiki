package com.x1oto.harrypotterwiki.presentation.view.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.x1oto.harrypotterwiki.data.models.character.CharacterItem
import com.x1oto.harrypotterwiki.data.models.spell.SpellItem
import com.x1oto.harrypotterwiki.databinding.FragmentCharactersBinding
import com.x1oto.harrypotterwiki.presentation.view.spells.SpellsFragmentDirections
import com.x1oto.harrypotterwiki.presentation.viewmodel.characters.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val charactersViewModel =
            ViewModelProvider(this).get(CharactersViewModel::class.java)

        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupBindingActions()

        charactersViewModel.fetchCharacters()
        charactersViewModel.status.observe(viewLifecycleOwner) { status ->
            binding.status = status
        }

        return root
    }

    private fun setupBindingActions() {
        with(binding) {
            onItemClicked = navigateToDetailedFragment()
        }
    }

    fun navigateToDetailedFragment(): (CharacterItem) -> Unit {
        return { character ->
            val action = CharactersFragmentDirections.actionNavigationCharactersToDetailedCharactersFragment(character)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}