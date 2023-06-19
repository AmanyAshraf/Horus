package com.example.horus.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.HotelData
import com.example.horus.data.model.HotelBody
import com.example.horus.databinding.RvHotelsBinding
import com.example.horus.presentation.ui.activity.HotelDetailsActivity

class HotelAdapter(var data: List<HotelBody>) :RecyclerView.Adapter<HotelAdapter.ViewHolder>() {
  //  private lateinit var mListener: onItemClickListener

    /*interface onItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }*/

   /* var data: List<HotelBody> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvHotelsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() =data.size

   inner class ViewHolder(private val binding: RvHotelsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HotelBody) = with(itemView) {
            binding.listItem=item

        }
        init {
            itemView.setOnClickListener {
                //listener.onItemClick(adapterPosition)
                val intent = Intent(itemView.context, HotelDetailsActivity::class.java)
                intent.putExtra("id",data.get(adapterPosition).id)
                intent.putExtra("name",data.get(adapterPosition).name)
                intent.putExtra("desc",data.get(adapterPosition).description)
                intent.putExtra("loc",data.get(adapterPosition).location)
                intent.putExtra("review",data.get(adapterPosition).review)
                intent.putExtra("lang",data.get(adapterPosition).languageSpoken)
                intent.putExtra("img",data.get(adapterPosition).image)
                itemView.context.startActivity(intent)

            }
        }
    }
}