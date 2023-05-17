package com.example.horus.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.horus.R
import com.example.horus.data.model.DataProfile
import com.example.horus.data.network.ApiService
import com.example.horus.databinding.ActivityEditProfileBinding
import com.example.horus.domain.repository.DataCreateProfile
import com.example.horus.presentation.viewmodel.CreateProfileViewModel
import com.example.horus.presentation.viewmodel.MainViewModelFactory

class EditProfileActivity : AppCompatActivity() {
    private lateinit var viewModel: CreateProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =DataBindingUtil.setContentView<ActivityEditProfileBinding>(
            this,R.layout.activity_edit_profile
        )
        val dataCreateProfile =DataCreateProfile()
        val viewModelFactory=MainViewModelFactory(dataCreateProfile)
        viewModel =ViewModelProvider(this,viewModelFactory).get(CreateProfileViewModel::class.java)

        binding.btnSave.setOnClickListener {
            viewModel.createProfile(dateOfBirth = "", phone = 1, codeCountry = "", userId = 0)
        }

    }
}