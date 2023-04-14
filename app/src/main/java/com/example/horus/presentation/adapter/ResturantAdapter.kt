package com.example.horus.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.ResturantData

class ResturantAdapter : RecyclerView.Adapter<ResturantAdapter.ViewHolder>(){
    private lateinit var mListener: onItemClickListener

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
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_hospital,parent,false)
        return ViewHolder(itemView,mListener)
    }

    override fun getItemCount() =data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
    class ViewHolder (itemView: View, listener:onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(item: ResturantData) = with(itemView) {
            findViewById<TextView>(R.id.tv_rv_hospital).text = item.name
            findViewById<ImageView>(R.id.im_rv_hospital).setImageResource(item.img)

        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }
}