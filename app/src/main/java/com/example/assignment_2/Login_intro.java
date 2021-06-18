package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_intro extends AppCompatActivity {
    private Button btnprimary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_intro);

        initaliaze();

        btnprimary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_intro.this, login.class);
                startActivity(intent);
            }
        });

    }
    private void initaliaze(){
        btnprimary = findViewById(R.id.btn_getStarted);
    }

}