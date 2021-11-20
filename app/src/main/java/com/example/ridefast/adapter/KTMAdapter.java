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
import com.example.ridefast.modal.Honda;
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

        return new KTMViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull KTMViewHolder holder, int position) {

        KTM ktm = ktmArrayList.get(position);

        Glide.with(context).load(ktm.getBackground()).into(holder.background);
        holder.name.setText(ktm.getName());
        holder.category.setText(ktm.getCategory());
        holder.price.setText(ktm.getPrice()+"$");
    }

    @Override
    public int getItemCount() {
        return ktmArrayList.size();
    }

    public class KTMViewHolder extends RecyclerView.ViewHolder {
        ImageView background;
        TextView name;
        TextView category;
        TextView price;

        public KTMViewHolder(@NonNull View itemView) {
            super(itemView);

            background = itemView.findViewById(R.id.background);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }
}
