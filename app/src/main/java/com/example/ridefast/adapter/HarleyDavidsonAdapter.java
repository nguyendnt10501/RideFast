package com.example.ridefast.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.ridefast.R;
import com.example.ridefast.activities.DetailActivity;
import com.example.ridefast.modal.HarleyDavidson;

import java.util.ArrayList;

public class HarleyDavidsonAdapter extends RecyclerView.Adapter<HarleyDavidsonAdapter.HarleyDavidsonViewHolder>{

    public Context context;
    public ArrayList<HarleyDavidson> harleyDavidsonList;

    public HarleyDavidsonAdapter(Context context, ArrayList<HarleyDavidson> harleyDavidsonList){
        this.context = context;
        this.harleyDavidsonList = harleyDavidsonList;
    }

    @NonNull
    @Override
    public HarleyDavidsonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HarleyDavidsonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HarleyDavidsonViewHolder holder, int position) {

        HarleyDavidson harleyDavidson = harleyDavidsonList.get(position);

        Glide.with(context).load(harleyDavidson.getImage()).into(holder.image);
        holder.name.setText(harleyDavidson.getName());
        holder.category.setText(harleyDavidson.getCategory());
        holder.price.setText(harleyDavidson.getPrice()+"$");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, DetailActivity.class);
                intent.putExtra("detailed",harleyDavidson);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return harleyDavidsonList.size();
    }

    public class HarleyDavidsonViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView category;
        TextView price;

        public HarleyDavidsonViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
