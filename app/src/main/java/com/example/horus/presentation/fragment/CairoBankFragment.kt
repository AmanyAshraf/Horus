package com.example.horus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentCairoBankBinding


class CairoBankFragment : Fragment() {
   private lateinit var binding:FragmentCairoBankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCairoBankBinding.inflate(inflater,container,false)
        binding.ivBackArrowBank.setOnClickListener {
            view?.findNavController()?.navigate(R.id.banksFragment)
        }
        return binding.root

    }


}