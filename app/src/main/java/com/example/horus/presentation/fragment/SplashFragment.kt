package com.example.horus.presentation.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentSplashBinding
import com.example.horus.presentation.activity.LoginViewModel
import com.example.horus.presentation.activity.MainActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



@Suppress("DEPRECATION")
class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSinInClient: GoogleSignInClient
    private lateinit var callbackManager: CallbackManager
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        // Inflate the layout for this fragment
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(com.firebase.ui.auth.R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSinInClient = GoogleSignIn.getClient(this.requireActivity(), gso)
        auth = FirebaseAuth.getInstance()
        checkUser()
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        binding.skipSplash.setOnClickListener(View.OnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_splashFragment_to_loginActivity)
        })
        binding.btnGoogle.setOnClickListener(View.OnClickListener {
            Log.d(TAG, "onCreate : begin Google signIN")
            val intent = googleSinInClient.signInIntent
            startActivityForResult(intent, RC_SING_IN)
        })
        callbackManager = CallbackManager.Factory.create()


        binding.btnFacebook.setOnClickListener(View.OnClickListener {

            userLoggedIn()
        })
        LoginManager.getInstance().registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {

                Log.d(TAG, "facebook:onSuccess:$loginResult")
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {
                Log.d(TAG, "facebook:onCancel")
            }

            override fun onError(error: FacebookException) {
                Log.d(TAG, "facebook:onError", error)
            }
        })

        binding.btnMail.setOnClickListener(View.OnClickListener {
            viewModel.authenticationState.observe(
                this.viewLifecycleOwner,
                Observer { authenticationState ->
                    when (authenticationState) {
                        LoginViewModel.AuthenticationState.Success -> {
                            successfullLogin()
                        }

                        else -> {
                            val providers = arrayListOf(
                                AuthUI.IdpConfig.EmailBuilder().build()
                            )


                            startActivityForResult(
                                AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers)
                                    .build(),
                                RC_SING_IN
                            )
                        }
                    }
                })

        })



        return binding.root


    }

    private fun successfullLogin() {
        val intent = Intent(this.requireContext(), MainActivity::class.java)
        startActivity(intent)


    }

    private fun userLoggedIn() {

        if (auth.currentUser != null) {
            auth.signOut()

        } else {
            LoginManager.getInstance().logInWithReadPermissions(
                this.requireActivity(),
                listOf("email", "public_profile")
            )
        }

    }


    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d(TAG, "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this.requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    startActivity(Intent(this.requireContext(), MainActivity::class.java))
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(
                        this.requireContext(), "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSplashBinding.inflate(layoutInflater)

    }

    private fun checkUser() {
        val authUser = auth.currentUser
        if (authUser != null) {
            startActivity(Intent(this.requireContext(), MainActivity::class.java))

        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SING_IN) {

            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                Log.i(
                    "VTSEN",
                    "Successfully signed in user " +
                            "${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
                successfullLogin()




            } else {

                Log.i("VTSEN", "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }


        callbackManager.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SING_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                Log.d(TAG, "FirebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed: ${e.message} ")
            }
        }
    }



    private fun firebaseAuthWithGoogle(idToken: String) {

        val credential = GoogleAuthProvider.getCredential(idToken,null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener{
                task ->
                Log.d(TAG,"firebaseAuthWithGoogle: LoggedIn")
                val authUser =auth.currentUser
                val uid = authUser?.uid
                val email = authUser?.email
                Log.d(TAG,"firebaseAuthWithGoogle:uid:$uid")
                Log.d(TAG,"firebaseAuthWithGoogle:email:$email")

                if (task.additionalUserInfo!!.isNewUser){
                    Log.d(TAG,"firebaseAuthWithGoogle:Account created...\n$email")
                    Toast.makeText(this@SplashFragment.requireContext(),"firebaseAuthWithGoogle:Account created...\n$email",Toast.LENGTH_SHORT).show()
                }else{
                    Log.d(TAG,"firebaseAuthWithGoogle:Exiting user...\n$email")
                        Toast.makeText(this@SplashFragment.requireContext(),"LoggedIn...\n$email",Toast.LENGTH_SHORT).show()
                }
                startActivity(Intent(this.requireContext(),MainActivity::class.java))
            }
            .addOnFailureListener {e->
            Log.d(TAG,"firebaseAuthWithGoogle: Logged failed due to ${e.message}")
            Toast.makeText(this@SplashFragment.requireContext(),"Logged failed due to ${e.message}",Toast.LENGTH_SHORT).show()

            }

    }

    companion object{
        const val RC_SING_IN =1001
        private const val TAG = "FacebookLogin"
    }


}