package com.example.horus.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.database.MuseumData
import com.example.horus.data.model.MuseumBody
import com.example.horus.data.model.RestaurantBody
import com.example.horus.databinding.FragmentMuseumsBinding
import com.example.horus.presentation.ui.activity.EgyptainMuseumActivity
import com.example.horus.presentation.ui.adapter.MuseumAdapter
import com.example.horus.presentation.viewmodel.MuseumViewModel
import com.example.horus.presentation.viewmodel.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MuseumsFragment : Fragment() {
    private lateinit var binding:FragmentMuseumsBinding
    private val viewModel: MuseumViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = FragmentMuseumsBinding.inflate(inflater,container,false)
        val items = mutableListOf<MuseumBody>()
        val adapterMuseum = MuseumAdapter(items.toList())
        binding.rvMuseum.adapter =adapterMuseum
        viewModel.response.observe(viewLifecycleOwner) {
            adapterMuseum.data= it
            adapterMuseum.notifyDataSetChanged()
        }
        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root
        }



}