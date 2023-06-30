package com.example.horus.presentation.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.horus.R
import com.example.horus.data.database.AntiquseDataMuseums
import com.example.horus.data.database.InstructionDataMuseums
import com.example.horus.databinding.ActivityEgyptainMuseumBinding
import com.example.horus.presentation.ui.adapter.AntiquesMuseumsAdapter
import com.example.horus.presentation.ui.adapter.InstructionMuseumsAdapter
import com.example.horus.presentation.ui.fragment.MuseumsFragment
import com.example.horus.presentation.ui.fragment.PlacesReviewFragment
import com.example.horus.presentation.ui.fragment.QFragment

class EgyptainMuseumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityEgyptainMuseumBinding>(this, R.layout.activity_egyptain_museum)
        setContentView(binding.root)
        binding.ivBackArrowMuseums.setOnClickListener {
            val intent =Intent(this , MuseumsFragment::class.java)
            startActivity(intent)
        }
        binding.tvReviews.setOnClickListener {
            replaceFragment(PlacesReviewFragment())
        }
        binding.tvQA.setOnClickListener {
            replaceFragment(QFragment())
        }
        var desc = intent.getStringExtra("desc")
        var id = intent.getIntExtra("id",0)
        var review = intent.getIntExtra("review",0)
        var loc = intent.getStringExtra("loc")
        var name = intent.getStringExtra("name")
        var website = intent.getStringExtra("website")
        var img = intent.getStringExtra("img")

        binding.tvDoubleEgyptianMuseum.text=name
        binding.tvEgyptainMuseum.text=name
        binding.tvInformation.text=desc
        binding.tvInforma.text=loc
        binding.tvReview.text=review.toString()

        Glide.with(this)
            .load(img)
            .into(binding.ivEgyptainMuesums)
        binding.tvVisitSite.setOnClickListener(View.OnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            startActivity(browserIntent)
        })

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager =supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainlayout,fragment)
        fragmentTransaction.commit()
    }

    }
