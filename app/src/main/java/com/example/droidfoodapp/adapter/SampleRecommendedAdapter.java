package com.example.droidfoodapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.droidfoodapp.R;
import com.example.droidfoodapp.domain.SampleFoodDomain;

import java.util.ArrayList;

public class SampleRecommendedAdapter extends RecyclerView.Adapter<SampleRecommendedAdapter.ViewHolder> {
    ArrayList<SampleFoodDomain> recommendedDomains;

    public SampleRecommendedAdapter(ArrayList<SampleFoodDomain> recommendedDomains) {
        this.recommendedDomains = recommendedDomains;
    }

    @NonNull
    @Override
    public SampleRecommendedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_recommended,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(recommendedDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(recommendedDomains.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources()
                .getIdentifier(recommendedDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return recommendedDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,fee;
        ImageView pic,addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }
}
