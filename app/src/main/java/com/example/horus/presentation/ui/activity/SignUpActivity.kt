package com.example.horus.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.horus.R
import com.example.horus.databinding.ActivitySignUpBinding
import com.example.horus.presentation.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    var p = true
    companion object {
       lateinit var userName :String
       lateinit var email : String
       lateinit var password : String
       lateinit var confirmPassword : String
       lateinit var name: String
    }
    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySignUpBinding>(
            this,
            R.layout.activity_sign_up
        )
        setContentView(binding.root)
        binding.btnSignUp.setOnClickListener(View.OnClickListener
        {
             userName = binding.etUserName.text.toString()
             email = binding.etEmailAddress.text.toString()
             password = binding.etPassword.text.toString()
             confirmPassword = binding.etConfirmPassword.text.toString()
             name = binding.etName.text.toString()
            if (binding.etEmailAddress.text.toString().isEmpty() && binding.etPassword.text.toString().isEmpty()&&
                binding.etName.text.toString().isEmpty()&&binding.etUserName.text.toString().isEmpty()&&
                binding.etConfirmPassword.text.toString().isEmpty()) {
                binding.etEmailAddress.error = "Require !"
                binding.etPassword.error = "Require !"
                binding.etName.error = "Require!"
                binding.etUserName.error = "Require!"
                binding.etConfirmPassword.error = "Require!"
            }
            else if (binding.etName.text.toString().isEmpty()) binding.etName.error = "Require!"
            else if (binding.etUserName.text.toString().isEmpty()) binding.etUserName.error = "Require!"
            else if (binding.etEmailAddress.text.toString().isEmpty()) binding.etEmailAddress.error = "Require!"
            else if (binding.etPassword.text.toString().isEmpty()) binding.etPassword.error = "Require!"
            else if (binding.etConfirmPassword.text.toString().isEmpty()) binding.etConfirmPassword.error = "Require!"
            else {

                // Show Progress Bar
                binding.progressBarSignup.visibility = View.VISIBLE
                // Disable user interactions
                this.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                val register = viewModel.register(name,userName, email, password,confirmPassword)
                register.observe(this) {
                    if (it==2) {
                        Toast.makeText(this, "Already Registered", Toast.LENGTH_SHORT).show()
                        binding.progressBarSignup.visibility = View.INVISIBLE
                        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
                    else if (it==1){
                        binding.progressBarSignup.visibility = View.INVISIBLE
                        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        if (already_taken_location) {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }
                        else {
                            val intent = Intent(this, LocationActivity::class.java)
                            startActivity(intent)
                        }
                    } else {
                        Toast.makeText(this, "Connection Error", Toast.LENGTH_SHORT)
                            .show()
                        binding.progressBarSignup.visibility = View.INVISIBLE
                        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
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