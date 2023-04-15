package com.example.horus.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.BankData


class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {


    var data: MutableList<BankData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_recentplaces_search, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: BankData) = with(itemView) {
            findViewById<TextView>(R.id.tv_rv_placeName_search).text = item.name
            findViewById<ImageView>(R.id.im_rv_placePic_search).setImageResource(item.img)
        }
    }
}