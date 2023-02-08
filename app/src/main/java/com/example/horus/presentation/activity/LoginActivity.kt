package com.example.horus.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    var b1=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        setContentView(binding.root)
        binding.btnSignInLogin.setOnClickListener(View.OnClickListener {
            if ( binding.edPasswordLogin.text.toString().isEmpty() && binding.edEmailLogin.text.toString().isEmpty()) {
                binding.edPasswordLogin.error = "Required!"
                binding.edEmailLogin.error = "Required!" }
            else if ( binding.edEmailLogin.text.toString().isEmpty()) binding.edEmailLogin.error = "Required!"
            else if ( binding.edPasswordLogin.text.toString().isEmpty()) binding.edPasswordLogin.error = "Required!"
            else {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })
        binding.btnSignUpLogin.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
        })
        binding.showPasswordLogin.setOnClickListener(View.OnClickListener {

            if(b1){
                binding.edPasswordLogin.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.showPasswordLogin.setImageResource(R.drawable.logo_black)
                b1=false
            } else{
                binding.edPasswordLogin.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.showPasswordLogin.setImageResource(R.drawable.logo_gray)
                b1=true
            }
        })

    }
}