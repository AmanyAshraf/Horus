package com.example.horus.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.horus.R
import com.example.horus.data.model.BankBody
import com.example.horus.databinding.FragmentBanksBinding
import com.example.horus.presentation.ui.adapter.BankAdapter
import com.example.horus.presentation.viewmodel.BankViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BanksFragment : Fragment() {
    private lateinit var binding:FragmentBanksBinding
    private val viewModel: BankViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBanksBinding.inflate(inflater,container,false)
        val items = mutableListOf<BankBody>()
       /* val Banks = mutableListOf<BankData>(
            BankData(R.drawable.cairo_bank,"Cairo Bank"),
            BankData(R.drawable.cairo_bank,"Masr Bank"),
            BankData(R.drawable.cairo_bank,"Alahaly Bank")

        )*/
        val adapterBank = BankAdapter(items.toList())
        binding.rvBank.adapter=adapterBank
       // adapterBank.data=Banks
       // val intent = Intent(this.requireContext(), BankDetailsActivity::class.java)
        viewModel.response.observe(viewLifecycleOwner) {
            adapterBank.data= it
            adapterBank.notifyDataSetChanged()
        }
       /* adapterBank.setOnItemClickListener(object : BankAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0-> startActivity(intent)
                }
            }
        })*/
        binding.ivBackArrowExplore.setOnClickListener {
            view?.findNavController()?.navigate(R.id.exploreFragment)
        }
        return binding.root
    }


}