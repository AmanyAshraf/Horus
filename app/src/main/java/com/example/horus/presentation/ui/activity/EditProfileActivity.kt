package com.example.horus.presentation.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.horus.R

import com.example.horus.databinding.ActivityEditProfileBinding
import com.example.horus.presentation.ui.activity.SignUpActivity.Companion.name
import com.example.horus.presentation.ui.activity.SignUpActivity.Companion.userName


class EditProfileActivity : AppCompatActivity() {
    companion object{
        lateinit var about:String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =DataBindingUtil.setContentView<ActivityEditProfileBinding>(
            this,R.layout.activity_edit_profile
        )

        binding.btnSave.setOnClickListener {
            about =binding.tvAboutYou.text.toString()
        }

    }
}