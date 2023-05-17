package com.example.horus.presentation.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySettingBinding>(
            this,R.layout.activity_setting
        )
      binding.tvAccountInfo.setOnClickListener {
          val intent =Intent(this,AccountInformationActivity::class.java)
          startActivity(intent)

      }
        binding.tvPreferences.setOnClickListener {
            val intent =Intent(this,PreferencesActivity::class.java)
            startActivity(intent)
        }



    }

}