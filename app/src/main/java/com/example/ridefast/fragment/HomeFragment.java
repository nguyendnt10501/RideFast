package com.example.ridefast.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ridefast.R;
import com.example.ridefast.activities.MainActivity;
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
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class HomeFragment extends Fragment{

    FirebaseFirestore db;

    RecyclerView rcvLogoCompany, rcvHarleyDavidson, rcvHonda, rcvKTM, rcvDucati, rcvYamaha, rcvKawasaki;
    ImageView menu;
    Toolbar toolbar;
    TextView seeAll;

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

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
        
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        //see all product method
        seeAll(view);

        //LogoCompanies
        showLogoCompany(view);

        //HarleyDavidson
        showHarleyDavidson(view);

        //Honda
        showHonda(view);

        //KTM
        showKTM(view);

        //Kawasaki
        showKawasaki(view);

        //Ducati
        showDucati(view);

        //Yamaha
        showYamaha(view);
    }

    //harley davidson recycler view
    private void showHarleyDavidson(View view){
        rcvHarleyDavidson = view.findViewById(R.id.rcvHarleyDavidson);
        harleyDavidsonArrayList = new ArrayList<HarleyDavidson>();
        harleyDavidsonAdapter = new HarleyDavidsonAdapter(getContext(), harleyDavidsonArrayList);

        rcvHarleyDavidson.setHasFixedSize(true);
        rcvHarleyDavidson.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rcvHarleyDavidson.setAdapter(harleyDavidsonAdapter);

        getDataHarleyDavidson();
    }
    //honda recycler view
    private void showHonda(View view){
        rcvHonda = view.findViewById(R.id.rcvHonda);
        hondaArrayList = new ArrayList<Honda>();
        hondaAdapter = new HondaAdapter(getContext(),hondaArrayList);

        rcvHonda.setHasFixedSize(true);
        rcvHonda.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        rcvHonda.setAdapter(hondaAdapter);

        getDataHonda();
    }
    //ktm recycler view
    private void showKTM(View view){
        rcvKTM = view.findViewById(R.id.rcvKTM);
        ktmArrayList = new ArrayList<KTM>();
        ktmAdapter = new KTMAdapter(getContext(),ktmArrayList);

        rcvKTM.setHasFixedSize(true);
        rcvKTM.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        rcvKTM.setAdapter(ktmAdapter);

//        getDataKTM();
    }
    //kawasaki recycler view
    private void showKawasaki(View view){
        rcvKawasaki = view.findViewById(R.id.rcvKawasaki);
        kawasakiArrayList = new ArrayList<Kawasaki>();
        kawasakiAdapter = new KawasakiAdapter(getContext(),kawasakiArrayList);

        rcvKawasaki.setHasFixedSize(true);
        rcvKawasaki.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        rcvKawasaki.setAdapter(kawasakiAdapter);

//        getDataKawasaki();
    }
    //yamaha recycler view
    private void showYamaha(View view){
        rcvYamaha = view.findViewById(R.id.rcvYamaha);
        yamahaArrayList = new ArrayList<Yamaha>();
        yamahaAdapter = new YamahaAdapter(getContext(),yamahaArrayList);

        rcvYamaha.setHasFixedSize(true);
        rcvYamaha.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        rcvYamaha.setAdapter(yamahaAdapter);

//        getDataYamaha();
    }
    //ducati recycler view
    private void showDucati(View view){
        rcvDucati = view.findViewById(R.id.rcvDucati);
        ducatiArrayList = new ArrayList<Ducati>();
        ducatiAdapter = new DucatiAdapter(getContext(),ducatiArrayList);

        rcvDucati.setHasFixedSize(true);
        rcvDucati.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        rcvDucati.setAdapter(ducatiAdapter);

//        getDataDucati();
    }
    //logo company recycler view
    private void showLogoCompany(View view){
        rcvLogoCompany = view.findViewById(R.id.rcvLogoCompany);
        logoCompanyAdapter = new LogoCompanyAdapter(getContext());

        rcvLogoCompany.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        logoCompanyAdapter.setData(getListLogoCompany());
        rcvLogoCompany.setAdapter(logoCompanyAdapter);
    }

    //see all method
    private void seeAll(View view){
        seeAll = view.findViewById(R.id.seeAll);
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProductFragment()).addToBackStack(null).commit();
            }
        });
    }

    //get data
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
