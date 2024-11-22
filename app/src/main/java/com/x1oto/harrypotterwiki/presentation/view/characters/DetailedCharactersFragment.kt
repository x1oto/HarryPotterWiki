package com.x1oto.harrypotterwiki.presentation.view.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.x1oto.harrypotterwiki.R
import com.x1oto.harrypotterwiki.databinding.FragmentDetailedCharactersBinding
import com.x1oto.harrypotterwiki.presentation.view.spells.DetailedSpellsFragmentArgs

class DetailedCharactersFragment : Fragment() {

    private val args by navArgs<DetailedCharactersFragmentArgs>()

    private var _binding: FragmentDetailedCharactersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailedCharactersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actorInfoTv.text = args.characterItem.actor
        binding.patronusInfoTv.text = args.characterItem.patronus
        binding.spellsInfoTv.text = args.characterItem.spellId.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}