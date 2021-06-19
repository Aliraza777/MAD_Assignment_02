package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login_intro extends AppCompatActivity {
    private Button btnprimary;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_intro);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        initaliaze();

        if(mAuth.getCurrentUser() != null){
            Toast.makeText(getApplicationContext() , "User is already Logged In ... " , Toast.LENGTH_LONG).show();
            try {
                redirect("MAIN");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        btnprimary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    redirect("LOGIN");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    private void initaliaze(){
        btnprimary = findViewById(R.id.btn_getStarted);
    }



    private void redirect(String name) throws Exception {
        Intent intent;
        if(name == "LOGIN"){
            intent = new Intent(this , login.class);
            startActivity(intent);
            finish();
        }
        else if(name == "MAIN"){
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            throw new Exception("no path exist");
        }

    }

}