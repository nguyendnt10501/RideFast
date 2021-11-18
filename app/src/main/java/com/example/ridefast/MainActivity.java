package com.example.ridefast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvLogoCompany, rcvHarleyDavidson;
    LogoCompanyAdapter logoCompanyAdapter;
    ArrayList<HarleyDavidson> harleyDavidsonArrayList;
    HarleyDavidsonAdapter harleyDavidsonAdapter;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvLogoCompany = findViewById(R.id.rcvLogoCompany);
        logoCompanyAdapter = new LogoCompanyAdapter(this);

        LinearLayoutManager rcvLogo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcvLogoCompany.setLayoutManager(rcvLogo);
        logoCompanyAdapter.setData(getListLogoCompany());
        rcvLogoCompany.setAdapter(logoCompanyAdapter);

// ----->

        db = FirebaseFirestore.getInstance();
        rcvHarleyDavidson = findViewById(R.id.rcvHarleyDavidson);

        rcvHarleyDavidson.setHasFixedSize(true);
        LinearLayoutManager rcvHarley = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcvHarleyDavidson.setLayoutManager(rcvHarley);

        harleyDavidsonArrayList = new ArrayList<HarleyDavidson>();
        harleyDavidsonAdapter = new HarleyDavidsonAdapter(MainActivity.this, harleyDavidsonArrayList);

        rcvHarleyDavidson.setAdapter(harleyDavidsonAdapter);
        EventChangeListener();
    }
    private void EventChangeListener() {
        db.collection("HarleyDavidson")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("====>", document.getId() + " => " + document.getData());

                                HarleyDavidson harleyDavidson = document.toObject(HarleyDavidson.class);
                                harleyDavidsonArrayList.add(harleyDavidson);
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
        return list;
    }
}