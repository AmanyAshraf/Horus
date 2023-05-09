package com.example.horus.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentPyramidsBinding

private lateinit var binding:FragmentPyramidsBinding
class PyramidsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPyramidsBinding.inflate(inflater,container,false)
        binding.ivBackArrowPyramids.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root

    }



}