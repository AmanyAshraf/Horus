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
import com.example.horus.data.model.BankBody
import com.example.horus.data.model.RestaurantBody
import com.example.horus.databinding.FragmentRestaurantsBinding
import com.example.horus.presentation.ui.activity.RestaurantDetailsActivity
import com.example.horus.presentation.ui.adapter.RestaurantAdapter
import com.example.horus.presentation.viewmodel.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantsFragment : Fragment() {
 private lateinit var binding:FragmentRestaurantsBinding
    private val viewModel: RestaurantViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRestaurantsBinding.inflate(inflater,container,false)
        val items = mutableListOf<RestaurantBody>()
        /* val Restaurants = mutableListOf<ResturantData>(
             ResturantData(R.drawable.restrant,"Old House Restaurant"),
             ResturantData(R.drawable.restrant,"Kfc")
         )*/
        val adapterRestaurant = RestaurantAdapter(items.toList())
        binding.rvRestaurant.adapter =adapterRestaurant
      //  adapterRestaurant.data=Restaurants
       // val intent = Intent(this.requireContext(), RestaurantDetailsActivity::class.java)
        viewModel.response.observe(viewLifecycleOwner) {
            adapterRestaurant.data= it
            adapterRestaurant.notifyDataSetChanged()
        }
        /*adapterRestaurant.setOnItemClickListener(object : ResturantAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0-> startActivity(intent)
                }
            }
        })*/
        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root
    }



}