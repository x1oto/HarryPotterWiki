package com.x1oto.harrypotterwiki.presentation.view.characters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
    private val binding get() = _binding!!

    val viewModel by viewModels<CharactersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupBindingActions()

        viewModel.fetchCharacters()
        viewModel.status.observe(viewLifecycleOwner) { status ->
            binding.status = status
        }

        return root
    }

    private fun setupBindingActions() {
        with(binding) {
            onItemClicked = navigateToDetailedFragment()
            onTeachClicked = teachSpell()
            onSwapHouse = swapHouse()
        }
    }

    fun navigateToDetailedFragment(): (CharacterItem) -> Unit {
        return { character ->
            val action = CharactersFragmentDirections.actionNavigationCharactersToDetailedCharactersFragment(character)
            findNavController().navigate(action)
        }
    }

    fun teachSpell(): (String) -> Unit {
        return { id ->
            viewModel.teachSpell(id)
        }
    }

    fun swapHouse(): (String) -> Unit {
        return { id ->
            viewModel.swapHouse(id)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}