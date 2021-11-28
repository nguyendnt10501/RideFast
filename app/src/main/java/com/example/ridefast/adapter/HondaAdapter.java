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
import com.example.ridefast.modal.Honda;

import java.util.ArrayList;

public class HondaAdapter extends RecyclerView.Adapter<HondaAdapter.HondaViewHolder>{

    public Context context;
    public ArrayList<Honda> hondaArrayList;

    public HondaAdapter(Context context, ArrayList<Honda> hondaArrayList){
        this.context = context;
        this.hondaArrayList = hondaArrayList;
    }

    @NonNull
    @Override
    public HondaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product_item,parent,false);
        return new HondaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HondaViewHolder holder, int position) {

        Honda honda = hondaArrayList.get(position);

        Glide.with(context).load(honda.getImage()).into(holder.image);
        holder.name.setText(honda.getName());
        holder.category.setText(honda.getCategory());
        holder.price.setText(honda.getPrice()+"$");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, DetailActivity.class);
                intent.putExtra("detailed",honda);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hondaArrayList.size();
    }

    public class HondaViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView category;
        TextView price;

        public HondaViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
