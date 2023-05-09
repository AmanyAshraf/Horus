package com.example.horus.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.horus.R
import com.example.horus.databinding.FragmentPlanBinding



class PlanFragment : Fragment() {
    private lateinit var binding: FragmentPlanBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentPlanBinding.inflate(inflater,container,false)

        return binding.root
    }
}