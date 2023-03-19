package com.example.horus.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.database.ResturantData
import com.example.horus.databinding.FragmentRestaurantsBinding
import com.example.horus.presentation.activity.OldHouseRestaurantActivity
import com.example.horus.presentation.adapter.ResturantAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantsFragment : Fragment() {
 private lateinit var binding:FragmentRestaurantsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRestaurantsBinding.inflate(inflater,container,false)
        val Restaurants = mutableListOf<ResturantData>(
            ResturantData(R.drawable.restrant,"Old House Restaurant"),
            ResturantData(R.drawable.restrant,"Kfc")
        )
        val adapterResturant = ResturantAdapter()
        binding.rvRestaurant.adapter =adapterResturant
        adapterResturant.data=Restaurants
        val intent = Intent(this.requireContext(), OldHouseRestaurantActivity::class.java)
        adapterResturant.setOnItemClickListener(object : ResturantAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0-> startActivity(intent)
                }
            }
        })
        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root
    }



}