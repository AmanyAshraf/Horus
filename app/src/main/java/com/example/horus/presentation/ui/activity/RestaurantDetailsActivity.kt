package com.example.horus.presentation.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.horus.R
import com.example.horus.databinding.ActivityRestaurantDetailsBinding
import com.example.horus.presentation.ui.fragment.PlacesReviewFragment
import com.example.horus.presentation.ui.fragment.QFragment

class RestaurantDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityRestaurantDetailsBinding>(this, R.layout.activity_restaurant_details)
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


        var desc = intent.getStringExtra("desc")
        var id = intent.getIntExtra("id",0)
        var loc = intent.getStringExtra("loc")
        var name = intent.getStringExtra("name")
        var telephone = intent.getStringExtra("telephone")
        var openFrom = intent.getStringExtra("openFrom")
        var openTo = intent.getStringExtra("openTo")
        var link = intent.getStringExtra("link")
        var img = intent.getStringExtra("img")
        var rate = intent.getIntExtra("rate",0)
        binding.tvResturantName.text=name
        binding.tvInformation.text=desc
        binding.tvLocRes.text=loc
        binding.tvOpensFrom.text=openFrom
        binding.tvTime.text=openTo
        binding.tvReview.text=rate.toString()
        Glide.with(this)
            .load(img)
            .into(binding.ivRestrauntImg)
        binding.tvVisitSite.setOnClickListener(View.OnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(browserIntent)
        })
        binding.tvTelephone.setOnClickListener(View.OnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL)
            phoneIntent.data = Uri.parse(telephone)
            startActivity(phoneIntent)
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager =supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainlayout,fragment)
        fragmentTransaction.commit()
    }

    }
