package com.example.horus.presentation.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivityAccountInformationBinding

class AccountInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =DataBindingUtil.setContentView<ActivityAccountInformationBinding>(
            this,R.layout.activity_account_information

        )
       binding.tvMyName.setOnClickListener {
           val intent = Intent(this,NameInfoActivity::class.java)
           startActivity(intent)
       }
        binding.tvName.setOnClickListener {
            val intent = Intent(this,NameInfoActivity::class.java)
            startActivity(intent)
        }
        binding.tvMangeContact.setOnClickListener {
            val intent =Intent(this,ContactInfoActivity::class.java)
            startActivity(intent)
        }
        binding.tvContactInfo.setOnClickListener {
            val intent =Intent(this,ContactInfoActivity::class.java)
            startActivity(intent)
        }
    }
}