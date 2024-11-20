package com.x1oto.harrypotterwiki.presentation.view.spells

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.x1oto.harrypotterwiki.R
import com.x1oto.harrypotterwiki.databinding.FragmentDetailedSpellsBinding


class DetailedSpellsFragment : Fragment() {

    private val args: DetailedSpellsFragmentArgs by navArgs()

    private var _binding: FragmentDetailedSpellsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailedSpellsBinding.inflate(layoutInflater, container, false)

        binding.spellDesc.text = args.spellItem.description

        return binding.root
    }

}