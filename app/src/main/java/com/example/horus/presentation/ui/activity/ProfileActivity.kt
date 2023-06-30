package com.example.horus.presentation.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivityProfileBinding
import com.example.horus.presentation.ui.activity.EditProfileActivity.Companion.about
import com.example.horus.presentation.ui.activity.SignUpActivity.Companion.name
import com.example.horus.presentation.ui.activity.SignUpActivity.Companion.userName

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val binding =
            DataBindingUtil.setContentView<ActivityProfileBinding>(this, R.layout.activity_profile)
        setContentView(binding.root)
        binding.ivSetting.setOnClickListener {
            val intent=Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        binding.ivProfileImage.setOnClickListener {
            val intent=Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
        binding.tvProfileInformation.text =about


    }
}