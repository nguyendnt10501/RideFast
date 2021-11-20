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
import com.example.ridefast.modal.KTM;

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

        return new DucatiViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DucatiViewHolder holder, int position) {

        Ducati ducati = ducatiArrayList.get(position);

        Glide.with(context).load(ducati.getBackground()).into(holder.background);
        holder.name.setText(ducati.getName());
        holder.category.setText(ducati.getCategory());
        holder.price.setText(ducati.getPrice()+"$");
    }

    @Override
    public int getItemCount() {
        return ducatiArrayList.size();
    }

    public class DucatiViewHolder extends RecyclerView.ViewHolder {
        ImageView background;
        TextView name;
        TextView category;
        TextView price;

        public DucatiViewHolder(@NonNull View itemView) {
            super(itemView);

            background = itemView.findViewById(R.id.background);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
