package com.example.horus.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.data.model.BankBody
import com.example.horus.databinding.RvBankBinding
import com.example.horus.presentation.ui.activity.BankDetailsActivity
import com.example.horus.presentation.ui.activity.HotelDetailsActivity


class BankAdapter (var data: List<BankBody>) : RecyclerView.Adapter<BankAdapter.ViewHolder>(){
   /* private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }*/

    /*var data: MutableList<BankData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvBankBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() =data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
   inner class ViewHolder (private val binding: RvBankBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BankBody) = with(itemView) {
            binding.listItem=item

        }

        init {
            itemView.setOnClickListener {
              //  listener.onItemClick(adapterPosition)
                val intent = Intent(itemView.context, BankDetailsActivity::class.java)
                intent.putExtra("id",data.get(adapterPosition).id)
                intent.putExtra("name",data.get(adapterPosition).name)
                intent.putExtra("desc",data.get(adapterPosition).description)
                intent.putExtra("loc",data.get(adapterPosition).location)
                intent.putExtra("img",data.get(adapterPosition).image)
                intent.putExtra("link",data.get(adapterPosition).link)
                intent.putExtra("telephone",data.get(adapterPosition).telephone)
                itemView.context.startActivity(intent)
            }

        }
    }
}