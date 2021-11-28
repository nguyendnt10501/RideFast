package com.example.ridefast.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ridefast.R;
import com.example.ridefast.modal.Ducati;
import com.example.ridefast.modal.HarleyDavidson;
import com.example.ridefast.modal.Honda;
import com.example.ridefast.modal.KTM;
import com.example.ridefast.modal.Kawasaki;
import com.example.ridefast.modal.Yamaha;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailActivity extends AppCompatActivity {

    ImageView image;
    TextView name, price, fuel, engine, setHeight, weight, speed;
    Button btnBuy;

    FirebaseFirestore firestore;

    HarleyDavidson harleyDavidson = null;
    Ducati ducati = null;
    Honda honda = null;
    Kawasaki kawasaki = null;
    KTM ktm = null;
    Yamaha yamaha = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        firestore = FirebaseFirestore.getInstance();
        hooks();
        detailMethod();

    }

    //hooks
    private void hooks(){
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        image = findViewById(R.id.image);
        btnBuy = findViewById(R.id.btnBuy);
    }
    //detail method
    private void detailMethod(){
        final Object obj = getIntent().getSerializableExtra("detailed");
        if(obj instanceof HarleyDavidson){
            harleyDavidson = (HarleyDavidson) obj;
        }
        if(obj instanceof Honda){
            honda = (Honda) obj;
        }
        if(obj instanceof Ducati){
            ducati = (Ducati) obj;
        }
        if(obj instanceof KTM){
            ktm = (KTM) obj;
        }
        if(obj instanceof Yamaha){
            yamaha = (Yamaha) obj;
        }
        if(obj instanceof Kawasaki){
            kawasaki = (Kawasaki) obj;
        }

        if(harleyDavidson != null){
            Glide.with(getApplicationContext()).load(harleyDavidson.getImage()).into(image);
            name.setText(harleyDavidson.getName());
            price.setText(harleyDavidson.getPrice()+"$");
        }
        if(honda != null){
            Glide.with(getApplicationContext()).load(honda.getImage()).into(image);
            name.setText(honda.getName());
            price.setText(honda.getPrice()+"$");
        }
        if(ducati != null){
            Glide.with(getApplicationContext()).load(ducati.getImage()).into(image);
            name.setText(ducati.getName());
            price.setText(ducati.getPrice()+"$");
        }
        if(kawasaki != null){
            Glide.with(getApplicationContext()).load(kawasaki.getImage()).into(image);
            name.setText(kawasaki.getName());
            price.setText(kawasaki.getPrice()+"$");
        }
        if(ktm != null){
            Glide.with(getApplicationContext()).load(ktm.getImage()).into(image);
            name.setText(ktm.getName());
            price.setText(ktm.getPrice()+"$");
        }
        if(yamaha != null){
            Glide.with(getApplicationContext()).load(yamaha.getImage()).into(image);
            name.setText(yamaha.getName());
            price.setText(yamaha.getPrice()+"$");
        }
    }
}