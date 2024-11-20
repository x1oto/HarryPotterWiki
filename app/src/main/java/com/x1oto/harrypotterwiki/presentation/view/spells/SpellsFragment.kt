package com.x1oto.harrypotterwiki.presentation.view.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.x1oto.harrypotterwiki.databinding.FragmentSpellsBinding
import com.x1oto.harrypotterwiki.presentation.viewmodel.spells.SpellsViewModel

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
        val spellsViewModel =
            ViewModelProvider(this).get(SpellsViewModel::class.java)

        _binding = FragmentSpellsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}