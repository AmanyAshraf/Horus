package com.example.horus.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivityPersonInformationBinding

class PersonInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_information)
        val binding =
            DataBindingUtil.setContentView<ActivityPersonInformationBinding>(this, R.layout.activity_person_information)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener (View.OnClickListener {
            if (binding.edYourName.text.isEmpty())
            {
                binding.edYourName.error = "Require"
            }
            else if (binding.edYourName.text.isEmpty())
                binding.edYourName.error = "Require"
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        })


    }
}