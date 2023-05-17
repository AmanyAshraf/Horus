package com.example.horus.presentation.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivityContactInfoBinding

class ContactInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =DataBindingUtil.setContentView<ActivityContactInfoBinding>(
            this,R.layout.activity_contact_info
        )
        binding.tvAddNumber.setOnClickListener {
            val intent =Intent(this,AddNumberActivity::class.java)
            startActivity(intent)
        }

    }
}