package com.example.horus.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.MuseumData

class MuseumAdapter : RecyclerView.Adapter<MuseumAdapter.ViewHolder>(){
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    var data: MutableList<MuseumData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_museums,parent,false)
        return ViewHolder(itemView,mListener)
    }

    override fun getItemCount() =data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
    class ViewHolder (itemView: View, listener:onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(item: MuseumData) = with(itemView) {
            findViewById<TextView>(R.id.tv_rv_museum).text = item.name
            findViewById<ImageView>(R.id.im_rv_museum).setImageResource(item.img)

        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }
}