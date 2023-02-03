package com.example.horus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
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
            ?.navigate(R.id.action_splashFragment_to_mainActivity) })
        binding.btnGoogle.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_mainActivity) })
        binding.btnFacebook.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_mainActivity) })
        binding.btnMail.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_mainActivity) })



        return binding.root


    }


}