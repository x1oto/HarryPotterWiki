package com.x1oto.harrypotterwiki.presentation.view.spells

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.x1oto.harrypotterwiki.databinding.FragmentSpellsBinding
import com.x1oto.harrypotterwiki.presentation.viewmodel.spells.SpellsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpellsFragment : Fragment() {

    private var _binding: FragmentSpellsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel by viewModels<SpellsViewModel>()

        _binding = FragmentSpellsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.fetchSpells()
        viewModel.status.observe(viewLifecycleOwner) { status ->
            binding.status = status
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}