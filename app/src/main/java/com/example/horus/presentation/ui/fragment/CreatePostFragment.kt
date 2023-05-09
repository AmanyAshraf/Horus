package com.example.horus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentCreatePostBinding


class CreatePostFragment : Fragment() {
         private lateinit var binding:FragmentCreatePostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCreatePostBinding.inflate(inflater,container,false)
        binding.imageView.setOnClickListener {
            view?.findNavController()?.navigate(R.id.communityFragment)
        }
        return binding.root

    }

}