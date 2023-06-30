package com.example.horus.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.horus.R
import com.example.horus.databinding.ActivityBankDetailsBinding
import com.example.horus.databinding.ActivitySearchItemDetailsBinding

class SearchItemDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivitySearchItemDetailsBinding>(this, R.layout.activity_search_item_details)
        setContentView(binding.root)


        var desc = intent.getStringExtra("desc")
        var id = intent.getIntExtra("id",0)
        var loc = intent.getStringExtra("loc")
        var name = intent.getStringExtra("name")
        var img = intent.getStringExtra("img")
        var type = intent.getStringExtra("type")

        binding.tvSearchName.text=name
        binding.tvSearchDesc.text=desc
        binding.tvSearchLoc.text=loc
        binding.tvSearchType.text=type
        Glide.with(this)
            .load(img)
            .into(binding.ivSearchImage)
    }
}