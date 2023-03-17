package com.example.horus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.horus.databinding.FragmentDoubleTreeHotelBinding

private lateinit var binding:FragmentDoubleTreeHotelBinding

class DoubleTreeHotelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDoubleTreeHotelBinding.inflate(inflater,container,false)
        binding.tvReviews.setOnClickListener {

        }
        return binding.root

    }


}