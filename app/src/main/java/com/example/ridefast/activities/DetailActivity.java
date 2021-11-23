package com.example.ridefast.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ridefast.R;
import com.example.ridefast.modal.HarleyDavidson;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailActivity extends AppCompatActivity {

    ImageView backgroundDetail;
    TextView name, price, fuel, engine, setHeight, weight, speed;
    Button btnBuy;

    FirebaseFirestore firestore;
    HarleyDavidson harleyDavidson = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        firestore = FirebaseFirestore.getInstance();
        final Object obj = getIntent().getSerializableExtra("detailed");
        if(obj instanceof HarleyDavidson){
            harleyDavidson = (HarleyDavidson) obj;
        }

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        backgroundDetail = findViewById(R.id.backgroundDetail);
        btnBuy = findViewById(R.id.btnBuy);

        if(harleyDavidson != null){
            Glide.with(getApplicationContext()).load(harleyDavidson.getBackgroundDetail()).into(backgroundDetail);
            name.setText(harleyDavidson.getName());
            price.setText(harleyDavidson.getPrice()+"$");
        }
    }
}