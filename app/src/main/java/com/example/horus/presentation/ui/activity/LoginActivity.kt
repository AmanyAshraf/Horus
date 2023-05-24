package com.example.horus.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivityLoginBinding
import com.example.horus.presentation.viewmodel.RegisterViewModel
import com.example.horus.presentation.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    var b1=true
    private val viewModel: SignInViewModel by viewModels()
    companion object {
        var token: String? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        setContentView(binding.root)
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
        binding.btnSignInLogin.setOnClickListener(View.OnClickListener {
            val email = binding.edEmailLogin.text.toString()
            val password = binding.edPasswordLogin.text.toString()
            if ( binding.edPasswordLogin.text.toString().isEmpty() && binding.edEmailLogin.text.toString().isEmpty()) {
                binding.edPasswordLogin.error = "Required!"
                binding.edEmailLogin.error = "Required!" }
            else if ( binding.edEmailLogin.text.toString().isEmpty()) binding.edEmailLogin.error = "Required!"
            else if ( binding.edPasswordLogin.text.toString().isEmpty()) binding.edPasswordLogin.error = "Required!"
            else {
                // Show Progress Bar
                binding.progressBarLogin.visibility = View.VISIBLE
                // Disable user interactions
                this.getWindow()
                    .setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                val login = viewModel.login(email, password)
                login.observe(this) {
                    if (it?.access?.isEmpty() == true){
                        binding.progressBarLogin.visibility = View.INVISIBLE
                        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        Toast.makeText(this, "There is Error", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        binding.progressBarLogin.visibility = View.INVISIBLE
                        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        })
        binding.btnSignUpLogin.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
        })


    }
}