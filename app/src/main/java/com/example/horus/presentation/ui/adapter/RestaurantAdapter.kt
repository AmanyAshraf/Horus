package com.example.horus.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.ResturantData
import com.example.horus.data.model.BankBody
import com.example.horus.data.model.RestaurantBody
import com.example.horus.databinding.RvBankBinding
import com.example.horus.databinding.RvResturantBinding
import com.example.horus.presentation.ui.activity.HotelDetailsActivity
import com.example.horus.presentation.ui.activity.RestaurantDetailsActivity

class RestaurantAdapter(var data: List<RestaurantBody>): RecyclerView.Adapter<RestaurantAdapter.ViewHolder>(){
   /* private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    var data: MutableList<ResturantData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
       val binding = RvResturantBinding.inflate(layoutInflater, parent, false)
       return ViewHolder(binding)
    }

    override fun getItemCount() =data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
   inner class ViewHolder (private val binding: RvResturantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RestaurantBody) = with(itemView) {
            binding.listItem=item
        }

        init {
            itemView.setOnClickListener {
               // listener.onItemClick(adapterPosition)
                val intent = Intent(itemView.context, RestaurantDetailsActivity::class.java)
                intent.putExtra("id",data.get(adapterPosition).id)
                intent.putExtra("name",data.get(adapterPosition).name)
                intent.putExtra("desc",data.get(adapterPosition).description)
                intent.putExtra("loc",data.get(adapterPosition).location)
                intent.putExtra("img",data.get(adapterPosition).image)
                intent.putExtra("website",data.get(adapterPosition).website)
                intent.putExtra("rate",data.get(adapterPosition).rating)
                intent.putExtra("telephone",data.get(adapterPosition).telephone)
                intent.putExtra("openFrom",data.get(adapterPosition).openFrom)
                intent.putExtra("openTo",data.get(adapterPosition).openTo)
                itemView.context.startActivity(intent)
            }

        }
    }
}