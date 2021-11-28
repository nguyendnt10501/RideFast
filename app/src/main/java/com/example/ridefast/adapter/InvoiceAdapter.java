package com.example.ridefast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ridefast.R;
import com.example.ridefast.modal.Invoice;

import java.util.ArrayList;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder>{

    public Context context;
    public ArrayList<Invoice> invoiceArrayList;

    public InvoiceAdapter(Context context){
        this.context = context;
    }
    public void setDataInvoice(ArrayList<Invoice> invoiceArrayList) {
        this.invoiceArrayList = invoiceArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new InvoiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_invoice,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position) {

        Invoice invoice = invoiceArrayList.get(position);

        Glide.with(context).load(invoice.getMainProduct()).into(holder.mainProduct);
        holder.name.setText(invoice.getName());
        holder.price.setText(invoice.getPrice());
    }

    @Override
    public int getItemCount() {
        return invoiceArrayList.size();
    }

    public class InvoiceViewHolder extends RecyclerView.ViewHolder {
        ImageView mainProduct,minus, plus;
        TextView price, name, quantity;

        int totalQuantity = 1;

        public InvoiceViewHolder(@NonNull View itemView) {
            super(itemView);

            mainProduct = itemView.findViewById(R.id.mainProduct);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            minus = itemView.findViewById(R.id.minus);
            plus = itemView.findViewById(R.id.plus);

            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(totalQuantity < 10){
                        totalQuantity++;
                        quantity.setText(String.valueOf(totalQuantity));
                    }
                }
            });

            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(totalQuantity > 1){
                        totalQuantity--;
                        quantity.setText(String.valueOf(totalQuantity));
                    }

                }
            });
        }
    }


}
