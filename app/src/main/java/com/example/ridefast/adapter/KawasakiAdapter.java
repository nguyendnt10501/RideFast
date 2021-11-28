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
import com.example.ridefast.modal.Kawasaki;

import java.util.ArrayList;

public class KawasakiAdapter extends RecyclerView.Adapter<KawasakiAdapter.KawasakiViewHolder>{

    public Context context;
    public ArrayList<Kawasaki> kawasakiArrayList;

    public KawasakiAdapter(Context context, ArrayList<Kawasaki> kawasakiArrayList){
        this.context = context;
        this.kawasakiArrayList = kawasakiArrayList;
    }

    @NonNull
    @Override
    public KawasakiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new KawasakiViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull KawasakiViewHolder holder, int position) {

        Kawasaki kawasaki = kawasakiArrayList.get(position);

        Glide.with(context).load(kawasaki.getImage()).into(holder.image);
        holder.name.setText(kawasaki.getName());
        holder.category.setText(kawasaki.getCategory());
        holder.price.setText(kawasaki.getPrice()+"$");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, DetailActivity.class);
                intent.putExtra("detailed",kawasaki);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kawasakiArrayList.size();
    }

    public class KawasakiViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView category;
        TextView price;

        public KawasakiViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
