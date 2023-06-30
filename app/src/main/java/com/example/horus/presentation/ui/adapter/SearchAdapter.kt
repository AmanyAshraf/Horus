package com.example.horus.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.BankData
import com.example.horus.data.model.RestaurantBody
import com.example.horus.data.model.SearchBody
import com.example.horus.databinding.RvBankBinding
import com.example.horus.databinding.RvResturantBinding
import com.example.horus.databinding.RvSearchItemBinding
import com.example.horus.presentation.ui.activity.RestaurantDetailsActivity
import com.example.horus.presentation.ui.activity.SearchItemDetailsActivity
import kotlinx.coroutines.NonDisposableHandle.parent


class SearchAdapter(var data: List<SearchBody>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val binding = RvSearchItemBinding.inflate(layoutInflater, parent, false)
    return ViewHolder(binding)
}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

   inner class  ViewHolder (private val binding: RvSearchItemBinding) :
       RecyclerView.ViewHolder(binding.root) {
       fun bind(item: SearchBody) = with(itemView) {
           binding.listItem=item
       }

       init {
           itemView.setOnClickListener {
               // listener.onItemClick(adapterPosition)
               val intent = Intent(itemView.context, SearchItemDetailsActivity::class.java)
               intent.putExtra("id",data.get(adapterPosition).id)
               intent.putExtra("name",data.get(adapterPosition).name)
               intent.putExtra("desc",data.get(adapterPosition).description)
               intent.putExtra("loc",data.get(adapterPosition).location)
               intent.putExtra("img",data.get(adapterPosition).image)
               intent.putExtra("type",data.get(adapterPosition).serviceType)
               itemView.context.startActivity(intent)
           }

       }
   }
}