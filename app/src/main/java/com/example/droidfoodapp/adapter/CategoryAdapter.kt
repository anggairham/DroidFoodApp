package com.example.droidfoodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.droidfoodapp.R
import com.example.droidfoodapp.domain.SampleCategoryDomain

class SampleCategoryAdapter(private val categoryDomains: ArrayList<SampleCategoryDomain>) :
    RecyclerView.Adapter<SampleCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
        val categoryPic: ImageView = itemView.findViewById(R.id.categoryPic)
        val mainLayout: View = itemView.findViewById(R.id.mainLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryDomains[position]
        holder.categoryName.text = category.title
        val picUrl = when (position) {
            0 -> "cat_1"
            1 -> "cat_2"
            2 -> "cat_3"
            3 -> "cat_4"
            4 -> "cat_5"
            else -> ""
        }
        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            picUrl, "drawable", holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.categoryPic)
    }

    override fun getItemCount(): Int {
        return categoryDomains.size
    }
}