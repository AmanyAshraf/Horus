package com.example.horus.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.database.HospitalData
import com.example.horus.databinding.FragmentHospitalBinding
import com.example.horus.presentation.ui.activity.CancerHosptalActivity
import com.example.horus.presentation.ui.adapter.HospitalAdapter


class HospitalFragment : Fragment() {

    private lateinit var binding:FragmentHospitalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHospitalBinding.inflate(inflater,container,false)
        val hospitals = mutableListOf<HospitalData>(
            HospitalData(R.drawable.hospital,"57375 Hospital")
        )
        val adapterHospital = HospitalAdapter()
        binding.rvHospital.adapter =adapterHospital
        adapterHospital.data=hospitals
        val intent = Intent(this.requireContext(), CancerHosptalActivity::class.java)
        adapterHospital.setOnItemClickListener(object : HospitalAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0-> startActivity(intent)
                }
            }
        })
        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return  binding.root
    }


}