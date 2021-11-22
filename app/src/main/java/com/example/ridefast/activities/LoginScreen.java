package com.example.ridefast.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ridefast.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {

    TextInputLayout email, password;
    TextView forgotPassword, jumpToSignup;
    Button btnLogin;
    ImageView facebook, google;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }


    public void login(View view){
        String aEmail = email.getEditText().getText().toString();
        String aPassword = password.getEditText().getText().toString();

        if(TextUtils.isEmpty(aEmail)){
            Toast.makeText(LoginScreen.this, "Enter email address", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(aPassword)){
            Toast.makeText(LoginScreen.this, "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(aEmail, aPassword)
                .addOnCompleteListener(LoginScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginScreen.this, "Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginScreen.this, MainActivity.class));
                        }
                        else{
                            Toast.makeText(LoginScreen.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void jumpToSignup(View view){
        startActivity(new Intent(LoginScreen.this,SignupScreen.class));
    }
}