package com.example.horus.presentation.ui.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.horus.R
import com.example.horus.databinding.ActivityCairoBankBinding
import com.example.horus.presentation.ui.fragment.PlacesReviewFragment
import com.example.horus.presentation.ui.fragment.QFragment

class CairoBankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityCairoBankBinding>(this, R.layout.activity_cairo_bank)
        setContentView(binding.root)
        binding.ivBackArrowBank.setOnClickListener {
            findViewById<ImageView>(R.id.museumsFragment)
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
