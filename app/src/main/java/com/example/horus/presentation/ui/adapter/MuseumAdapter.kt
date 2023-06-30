package com.example.horus.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.data.model.MuseumBody
import com.example.horus.databinding.RvMuseumsBinding
import com.example.horus.presentation.ui.activity.EgyptainMuseumActivity
import com.example.horus.presentation.ui.activity.SearchItemDetailsActivity

class MuseumAdapter (var data: List<MuseumBody>): RecyclerView.Adapter<MuseumAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvMuseumsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

    inner class  ViewHolder (private val binding: RvMuseumsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MuseumBody) = with(itemView) {
            binding.listItem=item
        }

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, EgyptainMuseumActivity::class.java)
                intent.putExtra("id",data.get(adapterPosition).id)
                intent.putExtra("name",data.get(adapterPosition).name)
                intent.putExtra("desc",data.get(adapterPosition).description)
                intent.putExtra("loc",data.get(adapterPosition).location)
                intent.putExtra("img",data.get(adapterPosition).image)
                intent.putExtra("website",data.get(adapterPosition).website)
                intent.putExtra("review",data.get(adapterPosition).reviewRate)
                itemView.context.startActivity(intent)
            }

        }
    }
}