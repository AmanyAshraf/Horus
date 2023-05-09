package com.example.horus.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.horus.R
import com.example.horus.data.database.BankData
import androidx.appcompat.widget.SearchView
import com.example.horus.databinding.FragmentSearchBinding
import com.example.horus.presentation.ui.adapter.SearchAdapter
import java.util.*

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    val places = mutableListOf<BankData>()
    val adapterPlaces = SearchAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSearchBinding.inflate(inflater,container,false)

        places.add( BankData(R.drawable.hospital,"57375 Hospital"))
        places.add( BankData(R.drawable.cairo_bank,"Cairo Bank"))
        places.add( BankData(R.drawable.hotel,"hotel"))
        places.add( BankData(R.drawable.restrant,"restaurant"))
        places.add( BankData(R.drawable.mentuhotep,"mentuhotep"))
        places.add( BankData(R.drawable.amenhotep,"amenhotep"))
        places.add( BankData(R.drawable.eg_museums,"Egyptian Museum"))


        binding.rvPlacesSearch.adapter =adapterPlaces
        adapterPlaces.data=places
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        return binding.root
    }
    fun filterList(query :String?){
        if (query != null){
            val filteredList =mutableListOf<BankData>()
            for (i in places){
                if (i.name.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(requireActivity(), "No Data Found", Toast.LENGTH_SHORT).show()
            }else{
                adapterPlaces.data=filteredList
                adapterPlaces.notifyDataSetChanged()
            }
        }
    }


}