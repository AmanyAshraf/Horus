package com.example.horus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.database.HotelData
import com.example.horus.databinding.FragmentHotelBinding
import com.example.horus.presentation.adapter.HotelAdapter


@Suppress("UNREACHABLE_CODE")
class HotelFragment : Fragment() {
    private lateinit var binding: FragmentHotelBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHotelBinding.inflate(inflater,container,false)
       val hotels = mutableListOf<HotelData>(
           HotelData(R.drawable.hotel_view,"Double Tree Hotel"),
           HotelData(R.drawable.hotel_view,"Giza Hotel"),
           HotelData(R.drawable.hotel_view,"Cairo Hotel"),
           HotelData(R.drawable.hotel_view,"MASSA Hotel")

       )
        val adapterHotel =HotelAdapter()
        binding.rvHotel.adapter =adapterHotel
        adapterHotel.data=hotels
        adapterHotel.setOnItemClickListener(object :HotelAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0-> view?.findNavController()?.navigate(R.id.doubleTreeHotelFragment)
                }
            }
        })
        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root
    }


}