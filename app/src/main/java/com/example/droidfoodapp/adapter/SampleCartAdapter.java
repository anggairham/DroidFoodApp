package com.example.droidfoodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.droidfoodapp.R;
import com.example.droidfoodapp.domain.SampleRecommendedDomain;
import com.example.droidfoodapp.helper.ChangeNumberItemListener;
import com.example.droidfoodapp.helper.ManagementCart;

import java.util.ArrayList;

public class SampleCartAdapter extends RecyclerView.Adapter<SampleCartAdapter.ViewHolder> {
    ArrayList<SampleRecommendedDomain> listFoodSelected;
    private ManagementCart managementCart;
    ChangeNumberItemListener changeNumberItemListener;

    public SampleCartAdapter(ArrayList<SampleRecommendedDomain> listFoodSelected, Context context,ChangeNumberItemListener changeNumberItemListener) {
        this.listFoodSelected = listFoodSelected;
        managementCart=new ManagementCart(context);
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public SampleCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_recommended,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listFoodSelected.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(listFoodSelected.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources()
                .getIdentifier(listFoodSelected.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,feeEachItem;
        ImageView pic,plusItem,minusItem;
        TextView totalEachItem,num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pic);
            feeEachItem=itemView.findViewById(R.id.fee);
            totalEachItem=itemView.findViewById(R.id.fee);
        }
    }
}
