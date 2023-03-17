package com.example.horus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentAlexResturantBinding


class AlexResturantFragment : Fragment() {
    private lateinit var binding:FragmentAlexResturantBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlexResturantBinding.inflate(inflater,container,false)
        binding.ivBackArrowRestaurant.setOnClickListener {
            view?.findNavController()?.navigate(R.id.restaurantsFragment)
        }
       return binding.root

    }


}