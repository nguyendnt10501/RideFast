package com.example.ridefast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.ridefast.adapter.DucatiAdapter;
import com.example.ridefast.adapter.HarleyDavidsonAdapter;
import com.example.ridefast.adapter.HondaAdapter;
import com.example.ridefast.adapter.KTMAdapter;
import com.example.ridefast.adapter.KawasakiAdapter;
import com.example.ridefast.adapter.LogoCompanyAdapter;
import com.example.ridefast.adapter.YamahaAdapter;
import com.example.ridefast.modal.Ducati;
import com.example.ridefast.modal.HarleyDavidson;
import com.example.ridefast.modal.Honda;
import com.example.ridefast.modal.KTM;
import com.example.ridefast.modal.Kawasaki;
import com.example.ridefast.modal.LogoCompany;
import com.example.ridefast.modal.Yamaha;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;

    RecyclerView rcvLogoCompany, rcvHarleyDavidson, rcvHonda, rcvKTM, rcvDucati, rcvYamaha, rcvKawasaki;

    ArrayList<HarleyDavidson> harleyDavidsonArrayList;
    ArrayList<Honda> hondaArrayList;
    ArrayList<KTM> ktmArrayList;
    ArrayList<Kawasaki> kawasakiArrayList;
    ArrayList<Yamaha> yamahaArrayList;
    ArrayList<Ducati> ducatiArrayList;

    LogoCompanyAdapter logoCompanyAdapter;
    HarleyDavidsonAdapter harleyDavidsonAdapter;
    HondaAdapter hondaAdapter;
    KTMAdapter ktmAdapter;
    YamahaAdapter yamahaAdapter;
    DucatiAdapter ducatiAdapter;
    KawasakiAdapter kawasakiAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

// ---------> LogoCompanies

        rcvLogoCompany = findViewById(R.id.rcvLogoCompany);
        logoCompanyAdapter = new LogoCompanyAdapter(this);

        rcvLogoCompany.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        logoCompanyAdapter.setData(getListLogoCompany());
        rcvLogoCompany.setAdapter(logoCompanyAdapter);

// ----------> Product - HarleyDavidson

        rcvHarleyDavidson = findViewById(R.id.rcvHarleyDavidson);
        harleyDavidsonArrayList = new ArrayList<HarleyDavidson>();
        harleyDavidsonAdapter = new HarleyDavidsonAdapter(MainActivity.this, harleyDavidsonArrayList);

        rcvHarleyDavidson.setHasFixedSize(true);
        rcvHarleyDavidson.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcvHarleyDavidson.setAdapter(harleyDavidsonAdapter);

        getDataHarleyDavidson();

// -----------> Product - Honda

        rcvHonda = findViewById(R.id.rcvHonda);
        hondaArrayList = new ArrayList<Honda>();
        hondaAdapter = new HondaAdapter(MainActivity.this,hondaArrayList);

        rcvHonda.setHasFixedSize(true);
        rcvHonda.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcvHonda.setAdapter(hondaAdapter);

        getDataHonda();

// -----------> Product - KTM

        rcvKTM = findViewById(R.id.rcvKTM);
        ktmArrayList = new ArrayList<KTM>();
        ktmAdapter = new KTMAdapter(MainActivity.this,ktmArrayList);

        rcvKTM.setHasFixedSize(true);
        rcvKTM.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcvKTM.setAdapter(ktmAdapter);

        getDataKTM();

// -----------> Product - Kawasaki

        rcvKawasaki = findViewById(R.id.rcvKawasaki);
        kawasakiArrayList = new ArrayList<Kawasaki>();
        kawasakiAdapter = new KawasakiAdapter(MainActivity.this,kawasakiArrayList);

        rcvKawasaki.setHasFixedSize(true);
        rcvKawasaki.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcvKawasaki.setAdapter(kawasakiAdapter);

        getDataKawasaki();

// -----------> Product - Ducati

        rcvDucati = findViewById(R.id.rcvDucati);
        ducatiArrayList = new ArrayList<Ducati>();
        ducatiAdapter = new DucatiAdapter(MainActivity.this,ducatiArrayList);

        rcvDucati.setHasFixedSize(true);
        rcvDucati.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcvDucati.setAdapter(ducatiAdapter);

        getDataDucati();

// -----------> Product - Yamaha

        rcvYamaha = findViewById(R.id.rcvYamaha);
        yamahaArrayList = new ArrayList<Yamaha>();
        yamahaAdapter = new YamahaAdapter(MainActivity.this,yamahaArrayList);

        rcvYamaha.setHasFixedSize(true);
        rcvYamaha.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcvYamaha.setAdapter(yamahaAdapter);

        getDataYamaha();

    }

    private void getDataHonda() {
        db.collection("Honda")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("====>", document.getId() + " => " + document.getData());

                                hondaArrayList.add(document.toObject(Honda.class));
                                hondaAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w("====>", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
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
    private void getDataKTM() {
        db.collection("KTM")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("====>", document.getId() + " => " + document.getData());

                                ktmArrayList.add(document.toObject(KTM.class));
                                ktmAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w("====>", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
    private void getDataKawasaki() {
        db.collection("Kawasaki")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("====>", document.getId() + " => " + document.getData());

                                kawasakiArrayList.add(document.toObject(Kawasaki.class));
                                kawasakiAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w("====>", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
    private void getDataDucati() {
        db.collection("Ducati")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("====>", document.getId() + " => " + document.getData());

                                ducatiArrayList.add(document.toObject(Ducati.class));
                                ducatiAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w("====>", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
    private void getDataYamaha() {
        db.collection("Yamaha")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("====>", document.getId() + " => " + document.getData());

                                yamahaArrayList.add(document.toObject(Yamaha.class));
                                yamahaAdapter.notifyDataSetChanged();
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