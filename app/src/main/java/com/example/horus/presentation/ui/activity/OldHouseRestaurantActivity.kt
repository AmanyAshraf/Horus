package com.example.horus.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.ActivityOldHouseRestaurantBinding
import com.example.horus.presentation.fragment.PlacesReviewFragment
import com.example.horus.presentation.fragment.QFragment

class OldHouseRestaurantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityOldHouseRestaurantBinding>(this, R.layout.activity_old_house_restaurant)
        setContentView(binding.root)
        binding.ivBackArrowRestaurant.setOnClickListener {
            findNavController(R.id.restaurantsFragment)
        }
        binding.tvReviews.setOnClickListener {

            replaceFragment(PlacesReviewFragment())
        }

        binding.tvQA.setOnClickListener {
            replaceFragment(QFragment())
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager =supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainlayout,fragment)
        fragmentTransaction.commit()
    }

    }
