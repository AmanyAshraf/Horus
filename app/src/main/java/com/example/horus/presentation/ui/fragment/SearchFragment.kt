package com.example.horus.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.horus.R
import com.example.horus.data.database.BankData
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.horus.data.model.HotelBody
import com.example.horus.data.model.SearchBody
import com.example.horus.databinding.FragmentSearchBinding
import com.example.horus.presentation.ui.adapter.SearchAdapter
import com.example.horus.presentation.viewmodel.HotelViewModel
import com.example.horus.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    val items = mutableListOf<SearchBody>()
    val adapterPlaces = SearchAdapter(items.toList())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSearchBinding.inflate(inflater,container,false)
        binding.rvPlacesSearch.adapter =adapterPlaces
        viewModel.response.observe(viewLifecycleOwner) {
            adapterPlaces.data= it
            adapterPlaces.notifyDataSetChanged()
        }
     binding.searchButton.setOnClickListener(View.OnClickListener {
           viewModel.search(binding.searchView.text.toString())

     })
        return binding.root
    }

}