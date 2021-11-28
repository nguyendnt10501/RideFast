package com.example.ridefast.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ridefast.R;
import com.example.ridefast.adapter.HarleyDavidsonAdapter;
import com.example.ridefast.adapter.LogoCompanyAdapter;
import com.example.ridefast.modal.HarleyDavidson;
import com.example.ridefast.modal.LogoCompany;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ProductFragment extends Fragment {

    FirebaseFirestore db;

    RecyclerView rcvLogoCompany, rcvProduct;
    ArrayList<HarleyDavidson> harleyDavidsonArrayList;
    LogoCompanyAdapter logoCompanyAdapter;
    HarleyDavidsonAdapter harleyDavidsonAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        //LogoCompanies
        showLogoCompany(view);

        //Product
        showProduct(view);

    }

    //product recycler view
    private void showProduct(View view){
        rcvProduct = view.findViewById(R.id.rcvProduct);
        harleyDavidsonArrayList = new ArrayList<HarleyDavidson>();
        harleyDavidsonAdapter = new HarleyDavidsonAdapter(getContext(), harleyDavidsonArrayList);

        rcvProduct.setHasFixedSize(true);
        rcvProduct.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rcvProduct.setAdapter(harleyDavidsonAdapter);

        getDataHarleyDavidson();
    }
    //logo company recycler view
    private void showLogoCompany(View view){
        rcvLogoCompany = view.findViewById(R.id.rcvLogoCompany);
        logoCompanyAdapter = new LogoCompanyAdapter(getContext());

        rcvLogoCompany.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        logoCompanyAdapter.setData(getListLogoCompany());
        rcvLogoCompany.setAdapter(logoCompanyAdapter);
    }

    //get data
    private void getDataHarleyDavidson() {
        db.collection("HarleyDavidson")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("====>", document.getId() + " => " + document.getData());

                                harleyDavidsonArrayList.add(document.toObject(HarleyDavidson.class));
                                harleyDavidsonAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w("====>", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
    public ArrayList<LogoCompany> getListLogoCompany() {
        ArrayList<LogoCompany> list = new ArrayList<>();

        list.add(new LogoCompany(R.drawable.kawasaki_logo));
        list.add(new LogoCompany(R.drawable.harley_logo));
        list.add(new LogoCompany(R.drawable.yamaha_logo));
        list.add(new LogoCompany(R.drawable.ducati_logo));
        list.add(new LogoCompany(R.drawable.honda_logo));
        list.add(new LogoCompany(R.drawable.ktm_logo));
        return list;
    }
}
