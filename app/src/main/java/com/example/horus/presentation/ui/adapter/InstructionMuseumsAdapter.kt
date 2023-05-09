package com.example.horus.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.InstructionDataMuseums

class InstructionMuseumsAdapter :RecyclerView.Adapter<InstructionMuseumsAdapter.ViewHolder>(){


    var data :MutableList<InstructionDataMuseums> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       val itemView =LayoutInflater.from(parent.context).inflate(R.layout.rv_instruction_museums,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) =holder.bind(data[position])

    override fun getItemCount() =data.size
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: InstructionDataMuseums)= with(itemView) {
            findViewById<TextView>(R.id.tv_rv_instruction_1).text=item.name_1
            findViewById<TextView>(R.id.tv_rv_instruction_2).text=item.name_2

        }

    }
}