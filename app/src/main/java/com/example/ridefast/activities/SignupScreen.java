package com.example.ridefast.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ridefast.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupScreen extends AppCompatActivity {

    TextInputLayout phoneNumber, email, password, rePassword;
    Button btnSignup;
    TextView jumpToLogin;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        auth = FirebaseAuth.getInstance();
        
        phoneNumber = findViewById(R.id.phoneNumber);
        email =  findViewById(R.id.email);
        password = findViewById(R.id.password);
        rePassword =  findViewById(R.id.rePassword);

    }

    public void signUp(View view){
        String aPhoneNumber = phoneNumber.getEditText().getText().toString();
        String aEmail = email.getEditText().getText().toString();
        String aPassword = password.getEditText().getText().toString();
        String aRePassword = rePassword.getEditText().getText().toString();

        if(TextUtils.isEmpty(aPhoneNumber)){
            Toast.makeText(SignupScreen.this, "Enter phone number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(aEmail)){
            Toast.makeText(SignupScreen.this, "Enter email address", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(aPassword)){
            Toast.makeText(SignupScreen.this, "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(aPassword.length() < 6){
            Toast.makeText(SignupScreen.this, "Password must have minimum 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(aRePassword)){
            Toast.makeText(SignupScreen.this, "Enter confirm password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!aPassword.equals(aRePassword)){
            Toast.makeText(SignupScreen.this, "Confirm password must be the same password", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(aEmail, aPassword)
                .addOnCompleteListener(SignupScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignupScreen.this, "Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupScreen.this, LoginScreen.class));
                        }
                        else{
                            Toast.makeText(SignupScreen.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void jumpToLogin(View view){
        startActivity(new Intent(SignupScreen.this,LoginScreen.class));
    }

}