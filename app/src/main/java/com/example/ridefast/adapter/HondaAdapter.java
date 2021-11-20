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
import com.example.ridefast.modal.HarleyDavidson;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new HondaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HondaViewHolder holder, int position) {

        Honda honda = hondaArrayList.get(position);

        Glide.with(context).load(honda.getBackground()).into(holder.background);
        holder.name.setText(honda.getName());
        holder.category.setText(honda.getCategory());
        holder.price.setText(honda.getPrice()+"$");
    }

    @Override
    public int getItemCount() {
        return hondaArrayList.size();
    }

    public class HondaViewHolder extends RecyclerView.ViewHolder {
        ImageView background;
        TextView name;
        TextView category;
        TextView price;

        public HondaViewHolder(@NonNull View itemView) {
            super(itemView);

            background = itemView.findViewById(R.id.background);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
