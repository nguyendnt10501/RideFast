package com.example.ridefast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ridefast.R;
import com.example.ridefast.modal.Ducati;
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

        return new YamahaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull YamahaViewHolder holder, int position) {

        Yamaha yamaha = yamahaArrayList.get(position);

        Glide.with(context).load(yamaha.getBackground()).into(holder.background);
        holder.name.setText(yamaha.getName());
        holder.category.setText(yamaha.getCategory());
        holder.price.setText(yamaha.getPrice()+"$");
    }

    @Override
    public int getItemCount() {
        return yamahaArrayList.size();
    }

    public class YamahaViewHolder extends RecyclerView.ViewHolder {
        ImageView background;
        TextView name;
        TextView category;
        TextView price;

        public YamahaViewHolder(@NonNull View itemView) {
            super(itemView);

            background = itemView.findViewById(R.id.background);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
