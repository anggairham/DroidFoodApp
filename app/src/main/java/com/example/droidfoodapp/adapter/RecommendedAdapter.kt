package com.example.droidfoodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.droidfoodapp.R
import com.example.droidfoodapp.domain.FoodDomain

class RecommendedAdapter(private val recommendedDomain: ArrayList<FoodDomain>)
    : RecyclerView.Adapter<RecommendedAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val fee: TextView = itemView.findViewById(R.id.fee)
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val addBtn: ImageView = itemView.findViewById(R.id.addBtn)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendedAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.viewholder_recommended, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendedAdapter.ViewHolder, position: Int) {
        val recommended = recommendedDomain[position]
        holder.title.text = recommended.title
        holder.fee.text = recommended.fee.toString()

        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            recommended.pic, "drawable", holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.pic)
    }

    override fun getItemCount(): Int {
        return recommendedDomain.size
    }
}