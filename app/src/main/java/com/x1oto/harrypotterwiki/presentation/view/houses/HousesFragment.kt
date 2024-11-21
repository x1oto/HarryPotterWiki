package com.x1oto.harrypotterwiki.presentation.view.houses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.x1oto.harrypotterwiki.databinding.FragmentHousesBinding
import com.x1oto.harrypotterwiki.presentation.adapters.recycler.HouseAdapter
import com.x1oto.harrypotterwiki.presentation.viewmodel.houses.HousesViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify

@AndroidEntryPoint
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
        val viewModel by viewModels<HousesViewModel>()

        _binding = FragmentHousesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button.setOnClickListener {
            viewModel.getCharactersByHouse("Gryffindor")
        }

        binding.button2.setOnClickListener {
            viewModel.getCharactersByHouse("Hufflepuff")
        }

        binding.button3.setOnClickListener {
            viewModel.getCharactersByHouse("Ravenclaw")
        }

        binding.button4.setOnClickListener {
            viewModel.getCharactersByHouse("Slytherin")
        }

        viewModel.status.observe(viewLifecycleOwner) { charByHouse ->
            if(charByHouse != null) {
                binding.housesRv.adapter = HouseAdapter(charByHouse)
            }
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}