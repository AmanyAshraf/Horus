package com.example.horus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.database.BankData
import com.example.horus.databinding.FragmentBanksBinding
import com.example.horus.presentation.adapter.BankAdapter


class BanksFragment : Fragment() {
    private lateinit var binding:FragmentBanksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBanksBinding.inflate(inflater,container,false)
        val Banks = mutableListOf<BankData>(
            BankData(R.drawable.cairo_bank,"Cairo Bank"),
            BankData(R.drawable.cairo_bank,"Masr Bank"),
            BankData(R.drawable.cairo_bank,"Alahaly Bank")

        )
        val adapterBank =BankAdapter()
        binding.rvBank.adapter=adapterBank
        adapterBank.data=Banks
        adapterBank.setOnItemClickListener(object : BankAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0-> view?.findNavController()?.navigate(R.id.cairoBankFragment)
                }
            }
        })
        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root
    }


}