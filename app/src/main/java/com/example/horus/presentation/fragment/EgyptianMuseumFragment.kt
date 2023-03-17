package com.example.horus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.database.AntiquseDataMuseums
import com.example.horus.data.database.InstructionDataMuseums
import com.example.horus.databinding.FragmentEgyptianMuseumBinding
import com.example.horus.presentation.adapter.AntiquesMuseumsAdapter
import com.example.horus.presentation.adapter.InstructionMuseumsAdapter

class EgyptianMuseumFragment : Fragment() {

    private lateinit var binding:FragmentEgyptianMuseumBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentEgyptianMuseumBinding.inflate(inflater,container,false)
        val antiques = mutableListOf<AntiquseDataMuseums>(
            AntiquseDataMuseums(R.drawable.mentuhotep,"Mentuhotep"),
            AntiquseDataMuseums(R.drawable.amenhotep,"Amenhotep")
        )
        val adapterAntiques = AntiquesMuseumsAdapter()
        binding.rvAntiques.adapter =adapterAntiques
        adapterAntiques.data = antiques
        adapterAntiques.setOnItemClickListener(object : AntiquesMuseumsAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0-> view?.findNavController()?.navigate(R.id.antiquesFragment)
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
            view?.findNavController()?.navigate(R.id.museumsFragment)
        }
        return binding.root

    }



}