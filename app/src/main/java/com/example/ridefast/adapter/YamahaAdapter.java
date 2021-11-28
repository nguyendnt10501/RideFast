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
import com.example.ridefast.modal.Yamaha;

import java.util.ArrayList;

public class YamahaAdapter extends RecyclerView.Adapter<YamahaAdapter.YamahaViewHolder>{

    public Context context;
    public ArrayList<Yamaha> yamahaArrayList;

    public YamahaAdapter(Context context, ArrayList<Yamaha> yamahaArrayList){
        this.context = context;
        this.yamahaArrayList = yamahaArrayList;
    }

    @NonNull
    @Override
    public YamahaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new YamahaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull YamahaViewHolder holder, int position) {

        Yamaha yamaha = yamahaArrayList.get(position);

        Glide.with(context).load(yamaha.getImage()).into(holder.image);
        holder.name.setText(yamaha.getName());
        holder.category.setText(yamaha.getCategory());
        holder.price.setText(yamaha.getPrice()+"$");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, DetailActivity.class);
                intent.putExtra("detailed",yamaha);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return yamahaArrayList.size();
    }

    public class YamahaViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView category;
        TextView price;

        public YamahaViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
