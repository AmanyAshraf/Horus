package com.example.horus.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivityAntiquesBinding

class AntiquesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityAntiquesBinding>(this, R.layout.activity_antiques)

        setContentView(binding.root)
        binding.ivBackArrowAntiques.setOnClickListener {
            val intent =Intent(this, EgyptainMuseumActivity::class.java)
            startActivity(intent)
        }

    }
}