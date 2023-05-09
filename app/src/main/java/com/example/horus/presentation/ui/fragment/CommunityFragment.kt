package com.example.horus.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentCommunityBinding
import com.example.horus.databinding.FragmentCreatePostImageBinding


class CommunityFragment : Fragment() {
    private lateinit var binding: FragmentCommunityBinding
    private lateinit var binding1: FragmentCreatePostImageBinding


    companion object{
        val IMAGE_REQUEST_CODE =100
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentCommunityBinding.inflate(inflater,container,false)
        binding.ivGroupPhoto.setOnClickListener {
            view?.findNavController()?.navigate(R.id.createPostImageFragment)
        }
        binding.btnInYourMind.setOnClickListener{
                view?.findNavController()?.navigate(R.id.createPostFragment)
        }
        binding.ivBackArrowCommuinty.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }

        return binding.root
    }




}