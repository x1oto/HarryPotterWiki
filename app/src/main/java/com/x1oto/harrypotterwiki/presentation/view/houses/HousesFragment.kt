package com.x1oto.harrypotterwiki.presentation.view.houses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.x1oto.harrypotterwiki.databinding.FragmentHousesBinding
import com.x1oto.harrypotterwiki.presentation.viewmodel.houses.HousesViewModel

class HousesFragment : Fragment() {

    private var _binding: FragmentHousesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val housesViewModel =
            ViewModelProvider(this).get(HousesViewModel::class.java)

        _binding = FragmentHousesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}