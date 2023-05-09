package com.example.horus.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    var p = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySignUpBinding>(
            this,
            R.layout.activity_sign_up
        )
        setContentView(binding.root)
        binding.btnSignUp.setOnClickListener(View.OnClickListener
        {
            if (binding.etEmailAddress.text.toString()
                    .isEmpty() && binding.etPassword.text.toString().isEmpty()
            ) {
                binding.etEmailAddress.error = "Require !"
                binding.etPassword.error = "Require !"

            } else if (binding.etEmailAddress.text.toString()
                    .isEmpty()
            ) binding.etEmailAddress.error = "Require!"
            else if (binding.etPassword.text.toString().isEmpty()) binding.etPassword.error = "Require!"
            else {
                if (already_taken_location) {
                    val intent = Intent(this, PersonInformationActivity::class.java)
                    startActivity(intent)
                }
                else {
                    val intent = Intent(this, LocationActivity::class.java)
                    startActivity(intent)
                }
            }

        })

        binding.btnSignIn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })
        binding.ivPasswordImageShow.setOnClickListener(View.OnClickListener {
            if (p) {
                binding.etPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                binding.ivPasswordImageShow.setImageResource(R.drawable.logo_black)
                p = false
            } else {
                binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.ivPasswordImageShow.setImageResource(R.drawable.logo_gray)
                p = true
            }
        })
        fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                android.R.id.home -> {
                    finish()
                    return true
                }
            }
            return super.onOptionsItemSelected(item)
        }

        findViewById<ImageView>(R.id.iv_back_arrow).setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}