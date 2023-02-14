package com.example.horus.presentation.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.horus.R
import com.example.horus.databinding.ActivityLocationBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationActivity : AppCompatActivity() {
    var ok = true
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = DataBindingUtil.setContentView<ActivityLocationBinding>(
            this,R.layout.activity_location
        )
        super.onCreate(savedInstanceState)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        binding.btnAllowLocation.setOnClickListener(View.OnClickListener {
            if (ok) {
                fetchLocation()
                ok = false
            } else {
                val intent = Intent(this, PersonInformationActivity::class.java)
                startActivity(intent)
                ok = true
            }
        })


        findViewById<TextView>(R.id.tv_not_now).setOnClickListener {
            val intent = Intent(this, PersonInformationActivity::class.java)
            startActivity(intent)
        } }
    private fun fetchLocation(){
        val task = fusedLocationProviderClient.lastLocation

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1000)
            return
        }
        task.addOnSuccessListener{
            if(it != null){
                Toast.makeText(applicationContext,"${it.latitude} ${it.longitude}",Toast.LENGTH_SHORT).show()
            }
        }
    }

}