package com.example.horus.presentation.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.horus.R
import com.example.horus.databinding.ActivityBankDetailsBinding
import com.example.horus.presentation.ui.fragment.PlacesReviewFragment
import com.example.horus.presentation.ui.fragment.QFragment

class BankDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityBankDetailsBinding>(this, R.layout.activity_bank_details)
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
        var desc = intent.getStringExtra("desc")
        var id = intent.getIntExtra("id",0)
        var loc = intent.getStringExtra("loc")
        var name = intent.getStringExtra("name")
        var telephone = intent.getStringExtra("telephone")
        var link = intent.getStringExtra("link")
        var img = intent.getStringExtra("img")
        binding.tvBankName.text=name
        binding.tvInformation.text=desc
        binding.tvLoc.text=loc
        Glide.with(this)
            .load(img)
            .into(binding.ivBankImage)
        binding.tvVisitWebsite.setOnClickListener(View.OnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(browserIntent)
        })
        binding.tvCall.setOnClickListener(View.OnClickListener {
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
