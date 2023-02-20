package com.example.horus.presentation.fragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.databinding.FragmentSplashBinding
import com.example.horus.presentation.activity.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Suppress("DEPRECATION")
class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSinInClient:GoogleSignInClient



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
        googleSinInClient= GoogleSignIn.getClient( this.requireActivity(),gso)
        auth =FirebaseAuth.getInstance()
        checkUser()
        binding=FragmentSplashBinding.inflate(inflater,container,false)

        binding.skipSplash.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_loginActivity) })
        binding.btnGoogle.setOnClickListener(View.OnClickListener {
            Log.d(TAG,"onCreate : begin Google signIN")
            val intent =googleSinInClient.signInIntent
            startActivityForResult(intent, RC_SING_IN) })
        binding.btnFacebook.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_loginActivity) })
        binding.btnMail.setOnClickListener(View.OnClickListener { view?.findNavController()
            ?.navigate(R.id.action_splashFragment_to_loginActivity) })



        return binding.root


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSplashBinding.inflate(layoutInflater)

    }

    private fun checkUser() {
       val authUser =auth.currentUser
        if (authUser !=null){
            startActivity(Intent(this.requireContext(),MainActivity::class.java))

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SING_IN){
            val task =GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account =task.getResult(ApiException::class.java)
                Log.d(TAG,"FirebaseAuthWithGoogle:"+account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            }catch (e:ApiException){
                Log.w(TAG,"Google sign in failed: ${e.message} ")
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
                val uid =authUser!!.uid
                val email =authUser!!.email
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
    }


}