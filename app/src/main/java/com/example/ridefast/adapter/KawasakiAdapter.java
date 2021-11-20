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

        return new KawasakiViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull KawasakiViewHolder holder, int position) {

        Kawasaki kawasaki = kawasakiArrayList.get(position);

        Glide.with(context).load(kawasaki.getBackground()).into(holder.background);
        holder.name.setText(kawasaki.getName());
        holder.category.setText(kawasaki.getCategory());
        holder.price.setText(kawasaki.getPrice()+"$");
    }

    @Override
    public int getItemCount() {
        return kawasakiArrayList.size();
    }

    public class KawasakiViewHolder extends RecyclerView.ViewHolder {
        ImageView background;
        TextView name;
        TextView category;
        TextView price;

        public KawasakiViewHolder(@NonNull View itemView) {
            super(itemView);

            background = itemView.findViewById(R.id.background);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
