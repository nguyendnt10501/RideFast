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
import com.example.ridefast.modal.Ducati;

import java.util.ArrayList;

public class DucatiAdapter extends RecyclerView.Adapter<DucatiAdapter.DucatiViewHolder>{

    public Context context;
    public ArrayList<Ducati> ducatiArrayList;

    public DucatiAdapter(Context context, ArrayList<Ducati> ducatiArrayList){
        this.context = context;
        this.ducatiArrayList = ducatiArrayList;
    }

    @NonNull
    @Override
    public DucatiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new DucatiViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DucatiViewHolder holder, int position) {

        Ducati ducati = ducatiArrayList.get(position);

        Glide.with(context).load(ducati.getImage()).into(holder.image);
        holder.name.setText(ducati.getName());
        holder.category.setText(ducati.getCategory());
        holder.price.setText(ducati.getPrice()+"$");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, DetailActivity.class);
                intent.putExtra("detailed",ducati);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ducatiArrayList.size();
    }

    public class DucatiViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView category;
        TextView price;

        public DucatiViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
