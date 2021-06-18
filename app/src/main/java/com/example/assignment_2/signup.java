package com.example.assignment_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    String email , password , confirmpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    }
    private void signUpUser(){
        email = findViewById(R.id.etEmailAddr).toString();
        password = findViewById(R.id.etPassword).toString();
        confirmpass = findViewById(R.id.etConfirmPassword).toString();



    }

}