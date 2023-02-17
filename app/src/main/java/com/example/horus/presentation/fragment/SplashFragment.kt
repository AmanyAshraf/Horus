package com.example.horus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding=FragmentSplashBinding.inflate(inflater,container,false)

        binding.skipSplash.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_loginActivity) })
        binding.btnGoogle.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_loginActivity) })
        binding.btnFacebook.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_loginActivity) })
        binding.btnMail.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_loginActivity) })



        return binding.root


    }


}