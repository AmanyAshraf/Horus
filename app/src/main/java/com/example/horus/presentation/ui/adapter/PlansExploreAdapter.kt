package com.example.horus.presentation.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horus.R
import com.example.horus.data.database.PlansDataExplore

class PlansExploreAdapter : RecyclerView.Adapter<PlansExploreAdapter.ViewHolder>() {


    var data: MutableList<PlansDataExplore> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_plan_explore, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PlansDataExplore) = with(itemView) {
            findViewById<TextView>(R.id.tv_rv_sellCondition_explore).text = item.sellCondition
            findViewById<TextView>(R.id.tv_rv_contentPlan_explore).text = item.content
            findViewById<TextView>(R.id.tv_rv_tourKind_explore).text = item.tourKind
            findViewById<TextView>(R.id.tv_rv_pricePlan_explore).text = item.price
            findViewById<ImageView>(R.id.im_rv_plan_explore).setImageResource(item.img)
        }
    }
}