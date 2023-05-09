package com.example.horus.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.horus.R
import com.example.horus.data.database.AntiquseDataMuseums
import com.example.horus.data.database.InstructionDataMuseums
import com.example.horus.databinding.ActivityEgyptainMuseumBinding
import com.example.horus.presentation.ui.adapter.AntiquesMuseumsAdapter
import com.example.horus.presentation.ui.adapter.InstructionMuseumsAdapter
import com.example.horus.presentation.ui.fragment.MuseumsFragment
import com.example.horus.presentation.ui.fragment.PlacesReviewFragment
import com.example.horus.presentation.ui.fragment.QFragment

class EgyptainMuseumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityEgyptainMuseumBinding>(this, R.layout.activity_egyptain_museum)

        setContentView(binding.root)
        val antiques = mutableListOf<AntiquseDataMuseums>(
            AntiquseDataMuseums(R.drawable.mentuhotep,"Mentuhotep"),
            AntiquseDataMuseums(R.drawable.amenhotep,"Amenhotep")
        )
        val adapterAntiques = AntiquesMuseumsAdapter()
        binding.rvAntiques.adapter =adapterAntiques
        adapterAntiques.data = antiques
        val intent =Intent(this , AntiquesActivity::class.java)
        adapterAntiques.setOnItemClickListener(object : AntiquesMuseumsAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0-> startActivity(intent)
                }
            }
        })
        val instruction = mutableListOf<InstructionDataMuseums>(
            InstructionDataMuseums("Last date to buy tickets","Ticket office closes 4:30 pm"),
            InstructionDataMuseums("Photo and video Tickets","foreign:\\nPhotography: 50 EGP Video: 300 EGP")
        )
        val adapterinstruction = InstructionMuseumsAdapter()
        binding.rvInstruction.adapter=adapterinstruction
        adapterinstruction.data=instruction
        binding.ivBackArrowMuseums.setOnClickListener {
            val intent =Intent(this , MuseumsFragment::class.java)
            startActivity(intent)
        }



        binding.tvReviews.setOnClickListener {

            replaceFragment(PlacesReviewFragment())
        }

        binding.tvQA.setOnClickListener {
            replaceFragment(QFragment())
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager =supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainlayout,fragment)
        fragmentTransaction.commit()
    }

    }
