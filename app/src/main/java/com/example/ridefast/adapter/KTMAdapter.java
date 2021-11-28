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
import com.example.ridefast.modal.KTM;

import java.util.ArrayList;

public class KTMAdapter extends RecyclerView.Adapter<KTMAdapter.KTMViewHolder>{

    public Context context;
    public ArrayList<KTM> ktmArrayList;

    public KTMAdapter(Context context, ArrayList<KTM> ktmArrayList){
        this.context = context;
        this.ktmArrayList = ktmArrayList;
    }

    @NonNull
    @Override
    public KTMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new KTMViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull KTMViewHolder holder, int position) {

        KTM ktm = ktmArrayList.get(position);

        Glide.with(context).load(ktm.getImage()).into(holder.image);
        holder.name.setText(ktm.getName());
        holder.category.setText(ktm.getCategory());
        holder.price.setText(ktm.getPrice()+"$");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, DetailActivity.class);
                intent.putExtra("detailed",ktm);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ktmArrayList.size();
    }

    public class KTMViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView category;
        TextView price;

        public KTMViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
