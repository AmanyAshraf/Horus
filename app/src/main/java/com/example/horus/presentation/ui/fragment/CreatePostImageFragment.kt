package com.example.horus.presentation.ui.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.audiofx.Equalizer.EXTRA_PACKAGE_NAME
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import coil.load
import com.example.horus.R
import com.example.horus.databinding.FragmentCreatePostImageBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener


@Suppress("DEPRECATION")
class CreatePostImageFragment : Fragment() {
    private lateinit var binding1: FragmentCreatePostImageBinding
    companion object{
        val IMAGE_REQUEST_CODE_1 =100
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding1 = FragmentCreatePostImageBinding.inflate(inflater,container,false)
        binding1.imageView.setOnClickListener {
            view?.findNavController()?.navigate(R.id.communityFragment)
        }
        binding1.ivYourImage.setOnClickListener {
            pickImageGallery()
        }
        return binding1.root
    }
    private fun pickImageGallery() {
        Dexter.withContext(this.requireContext()).withPermission(
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object :PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                gallery()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(this@CreatePostImageFragment.requireContext()
                    ,"you have denied ",
                    Toast.LENGTH_SHORT).show()

            }

            override fun onPermissionRationaleShouldBeShown(
                p0: PermissionRequest?,
                p1: PermissionToken?
            ) {
                showRotation()
            }

        }).onSameThread().check()

    }

    private fun gallery() {
        val intent = Intent()
        intent.action=Intent.ACTION_PICK
        intent.type="image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE_1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                IMAGE_REQUEST_CODE_1 ->{
                    binding1.ivYourImage.load(data?.data){
                        crossfade(true)
                        crossfade(1000)

                    }
                }
            }
        }
    }
    private fun showRotation(){
        AlertDialog.Builder(this.requireContext())
            .setMessage("it looks like you have turned off  permissions"+
            "required for this features")
            .setPositiveButton("go to setting"){_,_ ->
                try {
                    val intent=Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri=Uri.fromParts("Package", EXTRA_PACKAGE_NAME,null)
                    intent.data=uri
                    startActivity(intent)
                }catch (e:ActivityNotFoundException){
                    e.printStackTrace()
                }
            }
            .setNegativeButton("cancel"){dialog,_ ->
                dialog.dismiss()
            }.show()
    }

}