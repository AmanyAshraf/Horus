package com.example.horus.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.horus.R
import com.example.horus.databinding.ActivityDoubleTreeHotalBinding
import com.example.horus.presentation.ui.fragment.PlacesReviewFragment
import com.example.horus.presentation.ui.fragment.QFragment

class DoubleTreeHotalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityDoubleTreeHotalBinding>(this, R.layout.activity_double_tree_hotal)
        setContentView(binding.root)
        binding.tvReviews.setOnClickListener {

            replaceFragment(PlacesReviewFragment())
        }

       binding.tvQA.setOnClickListener {
           replaceFragment(QFragment())
        }

    }

    private fun replaceFragment(fragment:Fragment) {
        val fragmentManager =supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainlayout,fragment)
        fragmentTransaction.commit()
    }
}