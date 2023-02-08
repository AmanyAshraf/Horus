package com.example.horus.presentation.fragment


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentLogoBinding


class LogoFragment : Fragment() {
    private lateinit var binding: FragmentLogoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLogoBinding.inflate(inflater,container,false)

        Handler().postDelayed({
            view?.findNavController()
                ?.navigate(R.id.action_logoFragment_to_splashFragment)
        },2000)



        return binding.root


    }


}