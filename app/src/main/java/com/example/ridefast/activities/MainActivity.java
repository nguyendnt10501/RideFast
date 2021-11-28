package com.example.ridefast.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.ridefast.R;
import com.example.ridefast.adapter.DucatiAdapter;
import com.example.ridefast.adapter.HarleyDavidsonAdapter;
import com.example.ridefast.adapter.HondaAdapter;
import com.example.ridefast.adapter.KTMAdapter;
import com.example.ridefast.adapter.KawasakiAdapter;
import com.example.ridefast.adapter.LogoCompanyAdapter;
import com.example.ridefast.adapter.YamahaAdapter;
import com.example.ridefast.fragment.AccountFragment;
import com.example.ridefast.fragment.BestSellerFragment;
import com.example.ridefast.fragment.HomeFragment;
import com.example.ridefast.fragment.InvoiceFragment;
import com.example.ridefast.fragment.StatisticsFragment;
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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menu;
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hooks
        hooks();

        //navigation drawer
        navigationDrawer();
    }

    //navigation drawer
    public void navigationDrawer(){
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home);
        replaceFragment(new HomeFragment());

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    //navigation selected
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        item.setChecked(true);
        switch (id){
            case R.id.home:
                replaceFragment(new HomeFragment()); break;
            case R.id.bestSeller:
                replaceFragment(new BestSellerFragment()); break;
            case R.id.statistics:
                replaceFragment(new StatisticsFragment()); break;
            case R.id.invoice:
                replaceFragment(new InvoiceFragment()); break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //replace fragment method
    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
    }
    //hooks
    public void hooks(){
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        menu = findViewById(R.id.menuHamburger);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }
}