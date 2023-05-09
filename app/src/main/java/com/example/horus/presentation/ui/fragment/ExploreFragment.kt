package com.example.horus.presentation.ui.fragment

import ServicesExploreAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


import com.example.horus.R
import com.example.horus.data.database.PlansDataExplore
import com.example.horus.data.database.ServicesDataExplore
import com.example.horus.data.database.TopPlacesDataExplore
import com.example.horus.databinding.FragmentExploreBinding
import com.example.horus.presentation.ui.activity.EventActivity
import com.example.horus.presentation.ui.adapter.PlansExploreAdapter
import com.example.horus.presentation.ui.adapter.TopPlacesExploreAdapter


class ExploreFragment : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentExploreBinding.inflate(inflater,container,false)

        val services = mutableListOf<ServicesDataExplore>(
            ServicesDataExplore(R.drawable.hotel_explore,"Hotels"),
            ServicesDataExplore(R.drawable.mesum_explore,"Museums"),
            ServicesDataExplore(R.drawable.resturant_explore,"Restaurants"),
            ServicesDataExplore(R.drawable.hospital_explore,"Hospitals"),
            ServicesDataExplore(R.drawable.bank_explore,"Banks")
        )

        val adapterServices = ServicesExploreAdapter()
        binding.servicesRvExplore.adapter=adapterServices
        adapterServices.data = services
        adapterServices.setOnItemClickListener(object :ServicesExploreAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                when(position){
                    0-> view?.findNavController()?.navigate(R.id.hotelFragment)
                    1->view?.findNavController()?.navigate(R.id.museumsFragment)
                    2->view?.findNavController()?.navigate(R.id.restaurantsFragment)
                    3->view?.findNavController()?.navigate(R.id.hospitalFragment)
                    4->view?.findNavController()?.navigate(R.id.banksFragment)
                }

            }

        })

        val plans = mutableListOf<PlansDataExplore>(
            PlansDataExplore(R.drawable.plan_explore_1,"BEST SELLER","Giza Full-Day Private Tour with\nGovernment-Licensed Guide","Bus Tour","from \$574 per adult\n(price varies by group size)"),
            PlansDataExplore(R.drawable.plan_explore_2,"LIKELY TO SELL OUT","Ubud Tour-Best of Ubud-All\nInclusive","Full-day Tour’s","from \$7,469 per adult"),
            PlansDataExplore(R.drawable.plan_explore_3,"LIKELY TO SELL OUT","Phi Phi Islands Adventure Day\nTrip with Sea view Lunch by V.","Adventure ToursAdventure Tours","from \$7,141.11 per adult")
        )
        val adapterPlans = PlansExploreAdapter()
        binding.plansRvExplore.adapter=adapterPlans
        adapterPlans.data = plans

        val topPlaces = mutableListOf<TopPlacesDataExplore>(
            TopPlacesDataExplore(R.drawable.top_places_explore,"Pyramids"),
            TopPlacesDataExplore(R.drawable.top_places_explore,"Pyramids"),
            TopPlacesDataExplore(R.drawable.top_places_explore,"Pyramids")

        )
        val adapterTopPlaces = TopPlacesExploreAdapter()
        binding.topPlacesRvExplore.adapter=adapterTopPlaces
        adapterTopPlaces.data = topPlaces
        adapterTopPlaces.setOnItemClickListener(object : TopPlacesExploreAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                when(position){
                    0->view?.findNavController()?.navigate(R.id.pyramidsFragment)
                }
            }
        })
        binding.readMoreEventExplore.setOnClickListener(View.OnClickListener {

            val intent = Intent(activity, EventActivity::class.java)
            activity?.startActivity(intent)
        })
        return binding.root
    }

}