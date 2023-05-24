package com.example.horus.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.model.HotelBody
import com.example.horus.databinding.FragmentHotelBinding
import com.example.horus.presentation.ui.activity.HotelDetailsActivity
import com.example.horus.presentation.ui.adapter.HotelAdapter
import com.example.horus.presentation.viewmodel.HotelViewModel
import dagger.hilt.android.AndroidEntryPoint


@Suppress("UNREACHABLE_CODE")
@AndroidEntryPoint
class HotelFragment : Fragment() {
    private lateinit var binding: FragmentHotelBinding
    private val viewModel: HotelViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHotelBinding.inflate(inflater,container,false)
        val items = mutableListOf<HotelBody>()
     /*  val hotels = mutableListOf<HotelData>(
           HotelData(R.drawable.hotel_view,"Double Tree Hotel"),
           HotelData(R.drawable.hotel_view,"Giza Hotel"),
           HotelData(R.drawable.hotel_view,"Cairo Hotel"),
           HotelData(R.drawable.hotel_view,"MASSA Hotel")

       )*/
        val adapterHotel = HotelAdapter(items.toList())
        binding.rvHotel.adapter =adapterHotel
        //adapterHotel.data=hotels
        //val intent = Intent(this.requireContext(), HotelDetailsActivity::class.java)
        viewModel.response.observe(viewLifecycleOwner) {
            adapterHotel.data= it
            adapterHotel.notifyDataSetChanged()
        }
      /*  adapterHotel.setOnItemClickListener(object : HotelAdapter.onItemClickListener{

            override fun onItemClick(position: Int) {
                when(position){

                    0->startActivity(intent)
                }
            }
        })*/
        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root
    }


}