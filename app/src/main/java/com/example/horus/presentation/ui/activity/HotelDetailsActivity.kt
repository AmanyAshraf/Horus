package com.example.horus.presentation.ui.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.horus.R
import com.example.horus.databinding.ActivityHotelDetailsBinding
import com.example.horus.presentation.ui.fragment.PlacesReviewFragment
import com.example.horus.presentation.ui.fragment.QFragment

class HotelDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityHotelDetailsBinding>(this, R.layout.activity_hotel_details)
        setContentView(binding.root)
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
        var review = intent.getIntExtra("review",0)
        var lang = intent.getStringExtra("lang")
        var img = intent.getStringExtra("img")
        binding.tvHotelName.text=name
        binding.tvInformation.text=desc
        binding.tvReview.text=review.toString()
        binding.HotelLocation.text=loc
        binding.langaugeSpoken.text=lang
        Glide.with(this)
            .load(img)
            .into(binding.ivHotelView)

    }

    private fun replaceFragment(fragment:Fragment) {
        val fragmentManager =supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainlayout,fragment)
        fragmentTransaction.commit()
    }
}