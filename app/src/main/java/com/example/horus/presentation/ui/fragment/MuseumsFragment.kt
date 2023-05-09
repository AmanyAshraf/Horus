package com.example.horus.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.database.MuseumData
import com.example.horus.databinding.FragmentMuseumsBinding
import com.example.horus.presentation.ui.activity.EgyptainMuseumActivity
import com.example.horus.presentation.ui.adapter.MuseumAdapter


class MuseumsFragment : Fragment() {
    private lateinit var binding:FragmentMuseumsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = FragmentMuseumsBinding.inflate(inflater,container,false)
        val museums = mutableListOf<MuseumData>(
            MuseumData(R.drawable.eg_museums,"Egyptian Museum"),
            MuseumData(R.drawable.eg_museums,"cairo Museum")
        )
        val adapterMuseum = MuseumAdapter()
        binding.rvMuseum.adapter =adapterMuseum
        adapterMuseum.data =museums
        val intent = Intent(this.requireContext(), EgyptainMuseumActivity::class.java)
        adapterMuseum.setOnItemClickListener(object : MuseumAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0->startActivity(intent)
                }
            }
        })

        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root
        }



}