package com.example.ridefast.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ridefast.R;
import com.example.ridefast.adapter.InvoiceAdapter;
import com.example.ridefast.modal.Invoice;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class InvoiceFragment extends Fragment {


    RecyclerView rcvInvoice;
    InvoiceAdapter invoiceAdapter;
    Button btnAdd, btnPayment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_invoice, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hooks(view);

        //add button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddMotoDialog(Gravity.CENTER);
            }
        });

        //payment button
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddCompanyDialog(Gravity.CENTER);
            }
        });

        recyclerViewInvoice();

    }

    //add moto dialog
    public void openAddMotoDialog(int gravity) {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_moto_custom_dialog);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        } else {
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            WindowManager.LayoutParams windowAttributes = window.getAttributes();
            windowAttributes.gravity = gravity;
            window.setAttributes(windowAttributes);

            if (Gravity.CENTER == gravity) {
                dialog.setCancelable(false);
            } else {
                dialog.setCancelable(true);
            }

            TextInputLayout name, price, weight, speed, engine, fuel, volume;
            AutoCompleteTextView autoText;
            Button btnCancel, btnAdd;
            ImageView minus, plus, imageMoto;
            TextView quantityValue;
            final int[] quantity = {1};
            String[] companyItems = {"Harley Davidson","Honda","Kawasaki","Ducati","Yamaha","KTM"};
            ArrayAdapter<String> companyItemsList;

            btnCancel = dialog.findViewById(R.id.btnCancel);
            btnAdd = dialog.findViewById(R.id.btnAdd);
            minus = dialog.findViewById(R.id.minus);
            plus = dialog.findViewById(R.id.plus);
            quantityValue = dialog.findViewById(R.id.quantityValue);
            autoText = dialog.findViewById(R.id.autoText);

            companyItemsList = new ArrayAdapter<String>(getContext(),R.layout.companylogo_item,companyItems);
            autoText.setAdapter(companyItemsList);


            //cancel button
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            //add button
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Add Successfully", Toast.LENGTH_SHORT).show();
                }
            });

            dialog.show();

            //quantity of product
            plus.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (quantity[0] < 10) {
                        quantity[0]++;
                        quantityValue.setText(String.valueOf(quantity[0]));
                    }
                }
            });

            minus.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if (quantity[0] > 1) {
                        quantity[0]--;
                        quantityValue.setText(String.valueOf(quantity[0]));
                    }

                }
            });
        }
    }

    //add company dialog
    public void openAddCompanyDialog(int gravity) {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_company_custom_dialog);

        Window window = dialog.getWindow();

        if (window == null) {
            return;
        } else {
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            WindowManager.LayoutParams windowAttributes = window.getAttributes();
            windowAttributes.gravity = gravity;
            window.setAttributes(windowAttributes);

            if (Gravity.CENTER == gravity) {
                dialog.setCancelable(false);
            } else {
                dialog.setCancelable(true);
            }

            TextInputLayout name;
            Button btnAdd, btnCancel;
            ImageView imageLogo;

            name = dialog.findViewById(R.id.name);
            btnAdd = dialog.findViewById(R.id.btnAdd);
            btnCancel = dialog.findViewById(R.id.btnCancel);

            //cancel button
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            //button add
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Add Successfully", Toast.LENGTH_SHORT).show();
                }
            });

            dialog.show();
        }
    }

    //recycler view's data
    private ArrayList<Invoice> getListInvoice() {
        ArrayList<Invoice> list = new ArrayList<>();

        list.add(new Invoice("48", "23.000", R.drawable.fortyeight2));

        return list;

    }

    //invoice recycler view
    public void recyclerViewInvoice(){
        invoiceAdapter = new InvoiceAdapter(getContext());
        rcvInvoice.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        invoiceAdapter.setDataInvoice(getListInvoice());
        rcvInvoice.setAdapter(invoiceAdapter);
    }

    //hooks
    public void hooks(View view){
        rcvInvoice = view.findViewById(R.id.rcvInvoice);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnPayment = view.findViewById(R.id.btnPayment);
    }

}


