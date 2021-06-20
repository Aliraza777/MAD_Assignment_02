package com.example.assignment_2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_2.R;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String Tag = "Ali";
    private EditText emailV , passV ,confirmpassV;
    private Button btnSign;
    private TextView btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        signUpUser();

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void signUpUser(){
        emailV = findViewById(R.id.etEmailAddr);
        passV = findViewById(R.id.etPassword);
        confirmpassV = findViewById(R.id.etConfirmPassword);
        btnSign = findViewById(R.id.btnsignup);
        btnlogin = findViewById(R.id.gologinpage);
    }
    private void registerNewUser(){
        String email,password , confirmpass;
        email = emailV.getText().toString();
        password = passV.getText().toString();
        confirmpass = confirmpassV.getText().toString();

        if(TextUtils.equals(password, confirmpass)) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(signup.this, login.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                        }
                    });
        }
        else{
            Toast.makeText(getApplicationContext(),"Passwords does not match! , try again later...", Toast.LENGTH_LONG).show();
        }

        }


}