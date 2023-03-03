package com.example.horus.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.ServicesDataExplore

class ServicesExploreAdapter : RecyclerView.Adapter<ServicesExploreAdapter.ViewHolder>() {



        var data: MutableList<ServicesDataExplore> = mutableListOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_services_explore, parent, false)
            )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

        override fun getItemCount() = data.size

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: ServicesDataExplore) = with(itemView) {
                findViewById<TextView>(R.id.tv_rv_services).text = item.name
                findViewById<ImageView>(R.id.im_rv_services).setImageResource(item.img)
            }
        }

}